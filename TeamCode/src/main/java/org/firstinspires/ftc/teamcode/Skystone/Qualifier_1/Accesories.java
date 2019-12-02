package org.firstinspires.ftc.teamcode.Skystone.Qualifier_1;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Accesories {
    private LinearOpMode op = null;
    private HardwareMap hardwareMap = null;
    private ElapsedTime period = new ElapsedTime();
    DcMotor motorLift;
    Servo stone_claw_servo;
    ColorSensor tape_color_sensor;
    ColorSensor block_color_sensor;
    //variables for lifting mechanism
    double counts_per_motor_tetrix = 0;
    double counts_per_inch_lift = 0;

    public Accesories() {

        /******* Lift motor ********/
        counts_per_motor_tetrix = 1440; //TODO
        //counts_per_inch
        counts_per_inch_lift = 101; //550 for Tetrix and 100 for Hex
    }

    public void initChassis(LinearOpMode opMode) {
        op = opMode;
        hardwareMap = op.hardwareMap;
        // Lifting motors
        motorLift = hardwareMap.dcMotor.get("motorLift");
        // Claw Servo
        stone_claw_servo = hardwareMap.servo.get("stone_claw_servo");
        // Color Sensors
        block_color_sensor = hardwareMap.colorSensor.get("C1");
        // Lifting Motors
        motorLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorLift.setDirection(DcMotor.Direction.FORWARD);
        motorLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        stone_claw_servo.setPosition(1.0);
    }

    public void stopLift() {
        motorLift.setPower(0);
    }

    //true = unclamp, false = clamp
    public void clawClamp(boolean direction) {
        if (direction == true) {
            stone_claw_servo.setPosition(1.0);
        } else {
            stone_claw_servo.setPosition(0.0);
        }
        op.sleep(200);
    }

    //0.0 is clamped, 1.0 is unclamped
    public void clawClampPosition(double claw_position) {
        op.telemetry.addData("claw position :", claw_position);
        op.telemetry.update();
        stone_claw_servo.setPosition(claw_position);
        op.sleep(50);
    }

    //detects if red or if blue returns true and false
    public boolean tapeIsRed() {
        boolean redded = false;
        float hsvValues[] = {0F, 0F, 0F};
        final double SCALE_FACTOR = 255;
        // Color.RGBToHSV((tape_color_sensor.red()), (tape_color_sensor.green()), (tape_color_sensor.blue()), hsvValues);

        Color.RGBToHSV((int) (block_color_sensor.red() * SCALE_FACTOR),
                (int) (block_color_sensor.green() * SCALE_FACTOR),
                (int) (block_color_sensor.blue() * SCALE_FACTOR),
                hsvValues);
        if (hsvValues[0] >= 340 || hsvValues[0] <= 20) {
            redded = true;
            op.telemetry.addData("ColorSensorStatus", "Red");

        } else {
            op.telemetry.addData("ColorSensorStatus", "Unknown");
            redded = false;
        }
        op.telemetry.addLine()
                .addData("H", "%.3f", hsvValues[0])
                .addData("S", "%.3f", hsvValues[1])
                .addData("V", "%.3f", hsvValues[2]);
        op.telemetry.update();
        return redded;
    }

    public boolean tapeIsBlue() {
        boolean blued = false;
        float hsvValues[] = {0F, 0F, 0F};
        final double SCALE_FACTOR = 255;
        Color.RGBToHSV((int) (block_color_sensor.red() * SCALE_FACTOR),
                (int) (block_color_sensor.green() * SCALE_FACTOR),
                (int) (block_color_sensor.blue() * SCALE_FACTOR),
                hsvValues);
        op.telemetry.addLine()
                .addData("H", "%.3f", hsvValues[0])
                .addData("S", "%.3f", hsvValues[1])
                .addData("V", "%.3f", hsvValues[2]);
        op.telemetry.update();
        op.sleep(200);
        if (hsvValues[0] >= 200 && hsvValues[0] <= 275) {
            op.telemetry.addData("ColorSensorStatus", "Blue");
            blued = true;
        } else {
            op.telemetry.addData("ColorSensorStatus", "Unknown");
            blued = false;
        }
        op.telemetry.addLine()
                .addData("H", "%.3f", hsvValues[0])
                .addData("S", "%.3f", hsvValues[1])
                .addData("V", "%.3f", hsvValues[2]);
        op.telemetry.update();
        return blued;
    }

    public boolean blockIsYellow() {
        boolean chinese = false; //TODO CHINESE?????
        float hsvValues[] = {0F, 0F, 0F};
        final double SCALE_FACTOR = 255;
        Color.RGBToHSV((int) (block_color_sensor.red() * SCALE_FACTOR),
                (int) (block_color_sensor.green() * SCALE_FACTOR),
                (int) (block_color_sensor.blue() * SCALE_FACTOR),
                hsvValues);
        op.telemetry.addLine()
                .addData("H", "%.3f", hsvValues[0])
                .addData("S", "%.3f", hsvValues[1])
                .addData("V", "%.3f", hsvValues[2]);
        op.telemetry.update();
        op.sleep(200);
        if (hsvValues[0] >= 20 && hsvValues[0] <= 70 && hsvValues[2] >= 25) {
            op.telemetry.addData("ColorSensorStatus", "Yellow");
            chinese = true;
        } else {
            op.telemetry.addData("ColorSensorStatus", "Unknown");
            chinese = false;
        }
        op.telemetry.addLine()
                .addData("H", "%.3f", hsvValues[0])
                .addData("S", "%.3f", hsvValues[1])
                .addData("V", "%.3f", hsvValues[2]);
        op.telemetry.update();
        return chinese;

    }

    public boolean blockIsSky() {
        boolean black = false;
        float hsvValues[] = {0F, 0F, 0F};
        final double SCALE_FACTOR = 255;
        Color.RGBToHSV((int) (block_color_sensor.red() * SCALE_FACTOR),
                (int) (block_color_sensor.green() * SCALE_FACTOR),
                (int) (block_color_sensor.blue() * SCALE_FACTOR),
                hsvValues);
        op.telemetry.addLine()
                .addData("H", "%.3f", hsvValues[0])
                .addData("S", "%.3f", hsvValues[1])
                .addData("V", "%.3f", hsvValues[2]);
        op.telemetry.update();
        op.sleep(200);
        if (hsvValues[1] <= 0.5) {
            op.telemetry.addData("ColorSensorStatus", "Black");
            black = true;
        } else {
            op.telemetry.addData("ColorSensorStatus", "Unknown");
            black = false;
        }
        op.telemetry.addLine()
                .addData("H", "%.3f", hsvValues[0])
                .addData("S", "%.3f", hsvValues[1])
                .addData("V", "%.3f", hsvValues[2]);
        op.telemetry.update();
        return black;

    }

    /******** Lifting Motor **********/
    public void liftAutonomous(double liftheight) {
        double ticksToMove = counts_per_inch_lift * liftheight;
        int newmotorLift = (int) (motorLift.getCurrentPosition() + ticksToMove + 0.5); //adds .5 for rounding
        //TODO: Check limits for safety
        motorLift.setTargetPosition(newmotorLift);
        motorLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLift.setPower(1.0);
        while (op.opModeIsActive() && motorLift.isBusy()) {
            op.telemetry.addData("lifting ", motorLift.getCurrentPosition() + " busy=" + motorLift.isBusy());
            op.telemetry.update();
            op.idle();
        }
        //brake
        motorLift.setPower(0);
        motorLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void liftPosition(double liftposition){
        int ticksPosition = (int) (counts_per_inch_lift * liftposition + 0.5); //adds .5 for rounding
        motorLift.setTargetPosition(ticksPosition);
        motorLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLift.setPower(1.0);
        while (op.opModeIsActive() && motorLift.isBusy()) {
            op.telemetry.addData("lifting ", motorLift.getCurrentPosition() + " busy=" + motorLift.isBusy());
            op.telemetry.update();
            op.idle();
        }
        //brake
        motorLift.setPower(0);
        motorLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void liftTeleop_NotWorking(boolean up) { //true for up and false for down
        motorLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        if (up) {
            motorLift.setPower(1.0);
        } else {
            motorLift.setPower(-1.0);
        }
    }
}