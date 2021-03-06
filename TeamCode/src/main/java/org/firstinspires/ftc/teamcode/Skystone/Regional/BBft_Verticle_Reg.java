package org.firstinspires.ftc.teamcode.Skystone.Regional;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Skystone.Qualifier_1.hexChassis;

/**
 * <h1>first SkyStone autonomous program</h1>
 * for testing basicChassis that Nathan and Andrew wrote
 * <p>
 * Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author  Aiden Ma
 * @version 1.0
 * @since   2020-02-01
 */

@Disabled
@Autonomous(name = "BBft_Verticle_Reg")
public class BBft_Verticle_Reg extends LinearOpMode {

    private Robot_Reg robot = new Robot_Reg();
    private ElapsedTime runtime = new ElapsedTime();
    /*
    private Servo stone_claw_servo;
    private Servo foundationMoverRight;
    private Servo foundationMoverLeft;
*/

    /**
     * This method is for te autonomous operation of the robot on the Blue Alliance foundation side.
     * 1st you inPlaceTurn left
     * 2nd you go forward ~ 18 in.
     * 3rd you turn right
     * 4th you go forward ~ 24 in. to clamp the foundation
     * 5th you back up with the foundation clamped
     * 6th the unclamp the foundation
     * 7th you inPlaceTurn left
     * 8th move backward ~ 76 in.
     * 9th inPlaceTurn 90 degrees right
     * 10th move forward ~ 50 in.
     * 11th inPlaceTurn 130 degrees left
     * 12th move forward ~ 46 in.
     * 13th inPlaceTurn 90 degrees left
     * 8th you back up ~ 22 in. onto the blue line
     */
    @Override
    public void runOpMode() {

        //stone_claw_servo = hardwareMap.servo.get("stone_claw_servo");

        telemetry.addData("Status", "Ready to go");
        telemetry.update();

        robot.initChassis(this);

        // Aiden - during competition day robot dissconnected so we are trying this code
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command...");
            telemetry.update();
        }

        robot.liftPosition(2.5);
        robot.moveForwardIMU(26, 1);
        robot.moveForwardIMU(3, 0.15);
        robot.moveLeftIMU(14.5, 0.6);
        robot.moveForwardIMU(5, 0.2);
        robot.moveFoundationLefttdown(true);
        robot.moveFoundationRightdown(true);
        robot.moveBackwardIMU(40, 1.0);
        robot.moveFoundationLefttdown(false);
        robot.moveFoundationRightdown(false);
        robot.moveBackwardIMU(7, 0.2);
        robot.moveRightIMU(22, 01.0);
        robot.liftPosition(0);
        robot.moveRightUntilBlue(0.15);
        robot.clawClampPosition(0.0);


    }
}

