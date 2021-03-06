package org.firstinspires.ftc.teamcode.Skystone.Regional;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


/**
 * <h1> SkyStone autonomous program</h1>
 * <p>
 * Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author Aamod
 * @version 1.4
 * @since 2019-Dec-2
 */

@Disabled
@Autonomous(name = "B_stone2_parkCenter_turn_Reg")
public class B_stone2_parkCenter_turn_Reg extends LinearOpMode {
    Robot_Reg robot = new Robot_Reg();
    private ElapsedTime runtime = new ElapsedTime();
    private Servo stone_claw_servo;


    public B_stone2_parkCenter_turn_Reg() {

    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Ready to go");
        telemetry.update();
        robot.initChassis(this);
        telemetry.addData("Status", "InitComplete, Ready to Start");
        telemetry.update();

        //Wait for Start
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command...");
            telemetry.update();
        }
        robot.stopAllMotors();
        robot.moveForwardIMU(19, 0.9); // robot approaches stones
        robot.AbsoluteTurnIMU(0,2.5); // it still works with power 2.5
        robot.moveForward(6,0.3);
        //stop();
        /*
        double distance = robot.sensor.block_distance_sensor.getDistance(DistanceUnit.CM);
        robot.drivetrain.motorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.drivetrain.motorRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.drivetrain.motorLeftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.drivetrain.motorRightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        float power= (float) 0.5;
        robot.drivetrain.motorLeftBack.setPower(power);
        robot.drivetrain.motorRightBack.setPower(power);
        robot.drivetrain.motorLeftFront.setPower(power);
        robot.drivetrain.motorRightFront.setPower(power);
        // move forward until stone

        while(distance>4){
            distance = robot.sensor.block_distance_sensor.getDistance(DistanceUnit.CM);
            //idle()
        }

        robot.stopAllMotors();*/
        robot.clawClampPosition(0); // robot grabs stone
        sleep(300); // just in case
        robot.liftPositionNoWait(1);
        robot.moveBackward(11, 1); // robot moves away from stones
        robot.AbsoluteTurnIMU(90,0.6);
        robot.AbsoluteTurnIMU(90,2);
        robot.moveForward(37, 1);
        robot.clawClampPosition(1);
        robot.moveBackward(41, 1);
        robot.AbsoluteTurnIMU(38,1);
        robot.AbsoluteTurnIMU(0,1);
        robot.liftPositionNoWait(0);
        robot.moveForward(10, 0.25);

        /*double distance2 = robot.sensor.block_distance_sensor.getDistance(DistanceUnit.CM);
        robot.drivetrain.motorLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.drivetrain.motorRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.drivetrain.motorLeftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.drivetrain.motorRightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        float power2=(float)0.45;
        robot.drivetrain.motorLeftBack.setPower(power2);
        robot.drivetrain.motorRightBack.setPower(power2);
        robot.drivetrain.motorLeftFront.setPower(power2);
        robot.drivetrain.motorRightFront.setPower(power2);

        while(distance2>3.85){
            distance2 = robot.sensor.block_distance_sensor.getDistance(DistanceUnit.CM);
            //idle()
        }
        robot.stopAllMotors();*/
        robot.clawClampPosition(0); // robot grabs 2nd stone
        sleep(300);
        robot.liftPositionNoWait(1);
        robot.moveBackward(17, 1);
        robot.AbsoluteTurnIMU(90,0.6);
        robot.AbsoluteTurnIMU(90,2);
        robot.moveForward(43, 1);
        robot.clawClampPosition(1);
        robot.moveBackward(13, 1);
        robot.clawClampPosition(0);

    }
}
