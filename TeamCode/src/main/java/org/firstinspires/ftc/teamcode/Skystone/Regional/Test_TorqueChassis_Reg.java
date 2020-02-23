package org.firstinspires.ftc.teamcode.Skystone.Regional;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import android.os.Environment;

@Autonomous(name = "Test_TorqueChassis_Reg")
public class Test_TorqueChassis_Reg extends LinearOpMode{

    Robot_Reg robot = new Robot_Reg(); //TODO: private?
    private ElapsedTime runtime = new ElapsedTime();

    public void Test_TorqueChassis() {
    }

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Ready for Init");
        telemetry.update();
        robot.initChassis(this);

        //****** Wait for Start *******
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Status", "Waiting for start command...");
            telemetry.update();
        }

        /*double g=0.005;
        telemetry.addData("Gain Outside While:","G%3.3f\n",g);
        telemetry.update();
        //sleep(3000);


        while(g<0.1){
            telemetry.addData("Gain Inside While:","G%3.3f\n",g);
            telemetry.addData("MOVE RIGHT","%d",1);
            telemetry.update();
            sleep(250);
            //robot.moveRightIMU(30, 0.4,0.0,0.06,0.15);
            robot.moveRightIMU(30, 0.5,0,g,0.15);
            //sleep(5000);
            robot.AbsoluteTurnIMU(0,1);
            sleep(250);
            telemetry.addData("MOVE LEFT","%d",1);
            telemetry.update();
            //sleep(5000);
            robot.moveLeftIMU(30, 0.85,0,0.06,0.15);
            sleep(100);
            g=g+0.005;
            //g=g+0.06;
        }*/

        //robot.moveLeftIMU(36, 0.85,0,0.06,0.15);
        sleep(100);
        //robot.fasterMoveRightIMU(36,1);
        /*robot.moveRightIMU(36, 0.85, 90);
        sleep(100);
        robot.moveLeftIMU(36, 0.3, 0);
        sleep(100);
        robot.moveRightIMU(36, 0.3, 0);*/

        //robot.moveLeftIMU(36, 1, 0);
        //robot.moveRightIMU(36, 1, 0);

        //robot.moveLeftIMU(36, 0.5, 0);
        //robot.moveRightIMU(36, 0.5, 0);

/*
        robot.puller.foundationMoverLeft.setPosition(1);
        sleep(2000);
        robot.puller.foundationMoverRight.setPosition(0.0);
        sleep(2000);
*/
        //******* Lift Mechanism *******//
        robot.liftAutonomous(4);
        robot.clawClamp(false); //Clamp
        sleep(1500);
        robot.clawClamp(true); //Unclamp
        sleep(500);
        robot.liftAutonomous(-4);
        robot.liftPosition(4);
        robot.liftPosition(0, gamepad2);
        sleep(500);

        robot.inPlaceTurnIMU(90,1);
        robot.inPlaceTurnIMU(-180,1);
        robot.inPlaceTurnIMU(270,1);

        telemetry.addData("Order:", "LeftFront, RightFront, LeftBack, RightBack");
        telemetry.update();
        robot.moveMotorLeftFront(10);
        sleep(1000);
        robot.moveMotorRightFront(10);
        sleep(1000);
        robot.moveMotorLeftBack(10);
        sleep(1000);
        robot.moveMotorRightBack(10);
        sleep(1000);
        telemetry.addData("Status:", "MoveForward 5");
        telemetry.update();
        robot.moveForward(5,1);
        sleep(1000);
        telemetry.addData("Status:", "MoveBackward 5");
        telemetry.update();
        robot.moveBackward(5,1);
        sleep(1000);
        telemetry.addData("Status:", "MoveForward -5");
        telemetry.update();
        robot.moveForward(-5,1);
        sleep(1000);
        telemetry.addData("Status:", "MoveBackward -5");
        telemetry.update();
        robot.moveBackward(-5,1);
        sleep(1000);
        telemetry.addData("Status:", "MoveRight 5");
        telemetry.update();
        robot.moveRight(5,1);
        sleep(1000);
        telemetry.addData("Status:", "MoveLeft 5");
        telemetry.update();
        robot.moveLeft(5,1);
        sleep(1000);
        telemetry.addData("Status:", "MoveRight -5");
        telemetry.update();
        robot.moveRight(-5,1);
        sleep(1000);
        telemetry.addData("Status:", "MoveLeft -5");
        robot.moveLeft(-5,1);
        sleep(1000);
        telemetry.addData("Status:", "Turn inPlace Left");
        telemetry.update();
        robot.inPlaceTurn(90, true,1); //Left = true
        sleep(1000);
        telemetry.addData("Status:", "Turn inPlace Right");
        telemetry.update();
        robot.inPlaceTurn(90, false,1); //Right = false
        sleep(1000);
        telemetry.addData("Status:", "Turn normalTurn Left");
        telemetry.update();
        robot.inPlaceTurn(180, false,1); //Right = false
        sleep(1000);
        telemetry.addData("Status:", "Turn normalTurn Left");
        telemetry.update();
        robot.inPlaceTurn(180, true ,1 ); //Right = false
        sleep(1000);
        telemetry.addData("Status:", "Turn normalTurn Left");
        telemetry.update();



        /*robot.normalTurn(360, true); //Left = true
        sleep(2000);
        telemetry.addData("Status:", "Turn normalTurn Right");
        telemetry.update();
        robot.normalTurn(360, false); //Right = false
        */

        //move sideways left
        /*
        sleep(3000);
        telemetry.addData("Status:", "MoveBackward -5");
        telemetry.update();
        robot.moveBackward(-5);
        robot.moveBackward(70);
        telemetry.addData("What is Happening", "Robot drives towards Sksytones");
i        telemetry.update();
        sleep(500);
        */
        /*
        robot.inPlaceTurn(90, true);
        telemetry.addData("What is Happening", "Prepares to drive towards Skystones");
        telemetry.update();
        sleep(500);
        robot.moveForward(20);
        telemetry.addData("What is Happening", "Robot is in front of Skystones");
        telemetry.update();
        sleep(500);
            //servo arm down
        robot.moveBackward(8);
        telemetry.addData("What is Happening", "Robot backs away from Skystones");
        telemetry.update();
        sleep(500);
        robot.inPlaceTurn(90, true);
        telemetry.addData("What is Happening", "Prepares to go towards foundation");
        telemetry.update();
        sleep(500);
        robot.moveForward(60);
        telemetry.addData("What is Happening", "Robot drives towards Sksytones");
        telemetry.update();
        sleep(500);
        robot.inPlaceTurn(45, false);
        sleep(500);
        robot.moveForward(5);
        sleep(500);
        robot.inPlaceTurn(90, true);
        sleep(500);
        robot.moveForward(5);
        sleep(500);
        robot.inPlaceTurn(45, true);
        sleep(500);
        robot.moveForward(12);
        sleep(500);
        // foundation is now in corner
        robot.moveBackward(5);
        sleep(500);
        robot.inPlaceTurn(90, true);
        sleep(500);
        robot.moveForward(12);
        sleep(500);*/

        stop();
    }
}
