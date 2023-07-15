package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name = "newopmode2 (Blocks to Java)")
public class newopmode2 extends LinearOpMode {

  private DcMotor alexfront;
  private DcMotor simumfront;
  private Servo ServoMotor;
  private ColorSensor JedanJediniSenzor;
  private TouchSensor prvisenzor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double hand;
    double a;
    double s;

    alexfront = hardwareMap.get(DcMotor.class, "alexfront");
    simumfront = hardwareMap.get(DcMotor.class, "simumfront");
    ServoMotor = hardwareMap.get(Servo.class, "ServoMotor");
    JedanJediniSenzor = hardwareMap.get(ColorSensor.class, "JedanJediniSenzor");
    prvisenzor = hardwareMap.get(TouchSensor.class, "prvisenzor");

    // Put initialization blocks here.
    waitForStart();
    alexfront.setDirection(DcMotorSimple.Direction.REVERSE);
    alexfront.setPower(0);
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        telemetry.update();
        if (gamepad1.right_trigger > 0 && gamepad1.left_trigger > 0) {
          alexfront.setPower(0);
          simumfront.setPower(0);
        } else {
          if (gamepad1.right_trigger > 0) {
            a = gamepad1.right_trigger / 1.4;
          } else {
            a = -gamepad1.left_trigger / 1.4;
          }
          s = -gamepad1.left_stick_x / 1.4;
          if (s > 0) {
            simumfront.setPower((a - s * a) / 1.4);
            alexfront.setPower(a / 1.4);
          } else {
            alexfront.setPower((a + s * a) / 1.4);
            simumfront.setPower(a / 1.4);
          }
        }
        // #### BOJE ####
        ServoMotor.setPosition(hand);
        if (gamepad1.square) {
          hand = 0.4;
          ServoMotor.setPosition(hand);
        }
        if (gamepad1.circle) {
          hand = 0.05;
          ServoMotor.setPosition(hand);
        }
      }
    }
    simumfront.setPower(0);
  }
}
