package org.firstinspires.ftc.teamcode.Skystone.Unused;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Skystone.Outreach.basicChassis;

/**
 * <h1>first SkyStone TeleOp program</h1>
 * for testing basicChassis that Nathan and Andrew wrote
 * <p>
 * Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author Aiden Ma
 * @version 1.0
 * @since 2019-10-19
 */
@TeleOp(name = "SkyStone Teleop 1")

@Disabled
public class SkyStoneTeleop_Aiden_1 extends LinearOpMode {

    private basicChassis robot = new basicChassis();
    private ElapsedTime runtime = new ElapsedTime();


    public void SkyStoneAutonomous_Aiden_1() {

    }

    @Override
    public void runOpMode() {

        double leftPower;
        double rightPower;

        telemetry.addData("Status", "Ready to go");
        telemetry.update();
        robot.initChassis(this);


        waitForStart();
        robot.clawClamp(true);

        while (!isStopRequested()) {

            float left_stick_y = -gamepad1.left_stick_y;
            float right_stick_x = -gamepad1.right_stick_x;
            boolean stone_claw_up = gamepad1.x;
            boolean stone_claw_down = gamepad1.y;
            telemetry.addData("Motor","left (%.2f), right (%.2f)",left_stick_y, right_stick_x); telemetry.update();


            if ((left_stick_y == 1.00) && (right_stick_x == -0.00)) {
                telemetry.addData("Motor"," FORWARD left (%.2f), right (%.2f)",left_stick_y, right_stick_x); telemetry.update();
                robot.moveForward(3);
            }else if ((left_stick_y == -1.00) && (right_stick_x == -0.00)) {
                telemetry.addData("Motor"," BACKWARD left (%.2f), right (%.2f)",left_stick_y, right_stick_x); telemetry.update();
                robot.moveBackward(3);
            }else if ((left_stick_y == -0.00) && (right_stick_x == -1.00)) {
                telemetry.addData("Motor"," TURN RIGHT left (%.2f), right (%.2f)",left_stick_y, right_stick_x); telemetry.update();
                robot.inPlaceTurn(2,false);
            }else if ((left_stick_y == -0.00) && (right_stick_x == 1.00)){
                telemetry.addData("Motor"," TURN LEFT left (%.2f), right (%.2f)",left_stick_y, right_stick_x); telemetry.update();
                robot.inPlaceTurn(2,true);
            }else if (stone_claw_down = true) {
                telemetry.addData("Servo", " STONE CLAW Down");
                telemetry.update();
                robot.clawClamp(false);
            }else if (stone_claw_up = true){
                telemetry.addData("Servo", " STONE CLAW UP ");
                telemetry.update();
                robot.clawClamp(true);
            }

            telemetry.addData("Motor","left (%.2f), right (%.2f)",left_stick_y, right_stick_x);
            telemetry.update();
        }
    }
}