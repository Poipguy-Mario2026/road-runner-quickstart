package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="TeleOp_Main")
public class MainTeleOpMode extends LinearOpMode {
    private MecanumDrive drive;
   // public DcMotor IntakeMotor;


    @Override
    public void runOpMode() throws InterruptedException {
        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
       // IntakeMotor = hardwareMap.get(DcMotor.class, "IntakeMotor");
       // IntakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        while (opModeIsActive()) {
            double turn = gamepad1.left_stick_x;
            double d = gamepad1.left_stick_y;
            double rotate = gamepad1.right_stick_x * 0.5;

            Vector2d translationalVelocity = new Vector2d(1 * -d, -turn);
            double rotationalVelocity = -rotate;

            PoseVelocity2d velocity = new PoseVelocity2d(translationalVelocity, rotationalVelocity);

            drive.setDrivePowers(velocity);

            //Intake Code
           /* if(gamepad1.a == true){
                IntakeMotor.setPower(1);

            } else {
                IntakeMotor.setPower(0);
            }

            */






            telemetry.update();

        }

    }
}
