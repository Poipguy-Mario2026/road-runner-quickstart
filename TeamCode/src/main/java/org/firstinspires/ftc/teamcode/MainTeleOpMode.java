package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp_Main")
public class MainTeleOpMode extends LinearOpMode {
    private MecanumDrive drive;
    @Override
    public void runOpMode() throws InterruptedException {
        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        waitForStart();

        while (opModeIsActive()) {
            double turn = gamepad1.left_stick_x;
            double d = gamepad1.left_stick_y;
            double rotate = gamepad1.right_stick_x * 0.5;

            Vector2d translationalVelocity = new Vector2d(1 * -d, -turn);
            double rotationalVelocity = -rotate;

            PoseVelocity2d velocity = new PoseVelocity2d(translationalVelocity, rotationalVelocity);

            drive.setDrivePowers(velocity);

            telemetry.update();

        }

    }
}
