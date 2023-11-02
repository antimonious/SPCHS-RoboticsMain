package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "main")
public class magic extends LinearOpMode {



    private int rdirection = 1;
    private int ldirection = -1;
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor leftRear;
    private DcMotor rightRear;
    private DcMotor armmotor;
    private Servo drone;
    private Servo arm;
    private Servo riggingsupport;
    private DcMotor intakemotor;
    private double h = 0.5;
    private double g = 1;
    private boolean z;
    private Servo hand;
    private double k = -1;
    //  private double x = 0.4;
    private int c = 0;
    private double b = 0.5;
    private double r = 0.56;
    private double s;

    double frontLeftPower;
    double backLeftPower;
    double frontRightPower;
    double backRightPower;
    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        armmotor = hardwareMap.get(DcMotor.class, "armmotor");
        //intakemotor = hardwareMap.get(DcMotor.class, "intakemotor");
        drone = hardwareMap.get(Servo.class, "drone");
        arm = hardwareMap.get(Servo.class, "arm"); //wrist
        hand = hardwareMap.get(Servo.class, "hand");
        riggingsupport = hardwareMap.get(Servo.class, "riggingsupport");

        // Reverse one of the drive motors.
        // You will have to determine which motor to reverse for your robot.
        // In this example, the right motor was reversed so that positive
        // applied power makes it move the robot in the forward direction.
        waitForStart();
        if (opModeIsActive()) {
            drone.setPosition(0);
            riggingsupport.setPosition(0.56);
            rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
            leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                // The Y axis of a joystick ranges from -1 in its topmost position
                // to +1 in its bottommost position. We negate this value so that
                // the topmost position corresponds to maximum forward power.

                if (gamepad2.right_trigger > 0){
                    s = 1;

                } else {
                    if (gamepad2.left_trigger > 0){
                        s = 0.4;

                    } else {
                        s = 0.65;

                    }
                }

        /*
        leftback.setPower((gamepad2.left_stick_y - gamepad2.left_stick_x)*s);
        rightfront.setPower((gamepad2.left_stick_y - gamepad2.left_stick_x)*s);
        leftfront.setPower((-gamepad2.left_stick_y - gamepad2.left_stick_x)*s);
        rightback.setPower((-gamepad2.left_stick_y - gamepad2.left_stick_x)*s);
        */

        /*
        double y = -gamepad2.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad2.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad2.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
         double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;


        leftfront.setPower(frontLeftPower);
        leftback.setPower(backLeftPower);
        rightfront.setPower(frontRightPower);
        rightback.setPower(backRightPower);
        */
        /*
        if ((power + Math.abs(turn))>1) {
          leftfront.setPower(power+turn);
          rightfront.setPower(power+turn)
        }
        */
        /*
        if (gamepad2.right_trigger > 0){
          leftback.setPower(gamepad2.left_stick_y - gamepad2.left_stick_x);
          rightfront.setPower(gamepad2.left_stick_y - gamepad2.left_stick_x);
          leftfront.setPower(-gamepad2.left_stick_y - gamepad2.left_stick_x);
          rightback.setPower(-gamepad2.left_stick_y - gamepad2.left_stick_x);

        } else {
          if (gamepad2.left_trigger > 0){
            leftback.setPower((gamepad2.left_stick_y - gamepad2.left_stick_x)*x);
            rightfront.setPower((gamepad2.left_stick_y - gamepad2.left_stick_x)*x);
            leftfront.setPower((-gamepad2.left_stick_y - gamepad2.left_stick_x)*x);
            rightback.setPower((-gamepad2.left_stick_y - gamepad2.left_stick_x)*x);
          } else {
            leftback.setPower((gamepad2.left_stick_y - gamepad2.left_stick_x)*c);
            rightfront.setPower((gamepad2.left_stick_y - gamepad2.left_stick_x)*c);
            leftfront.setPower((-gamepad2.left_stick_y - gamepad2.left_stick_x)*c);
            rightback.setPower((-gamepad2.left_stick_y - gamepad2.left_stick_x)*c);
          }
        }
        */
                //intakemotor.setPower(gamepad1.right_trigger);


                armmotor.setPower(gamepad1.right_stick_y);
                if (0.35 <= (h - (gamepad1.left_stick_y/1000)) && (h - (gamepad1.left_stick_y/1000)) <= 0.96){
                    h = h - (gamepad1.left_stick_y/1000);
                }

                ///////////////////////////////////////////////////////

        /*
        leftfront.setPower((gamepad1.right_stick_y)*s);
        leftback.setPower((gamepad1.right_stick_y)*s);
        rightfront.setPower((gamepad1.right_stick_y)*s);
        rightback.setPower(((gamepad1.right_stick_y)*s);

        */


                /////////////////////////////////////////////////////////

                if (gamepad2.dpad_left){
                    leftFront.setPower(s);
                    leftRear.setPower(s);
                    rightFront.setPower(-s);
                    rightRear.setPower(-s);
                }
                if (gamepad2.dpad_right){
                    leftFront.setPower(-s);
                    leftRear.setPower(-s);
                    rightFront.setPower(s);
                    rightRear.setPower(s);
                }
                if (gamepad2.dpad_up){
                    leftFront.setPower(s);
                    leftRear.setPower(s);
                    rightFront.setPower(s);
                    rightRear.setPower(s);
                }
                if (gamepad2.dpad_down){
                    leftFront.setPower(-s);
                    leftRear.setPower(-s);
                    rightFront.setPower(-s);
                    rightRear.setPower(-s);
                }

                //////////////////////////////////////////////////////////////

                double y = -gamepad2.left_stick_y; // Remember, Y stick value is reversed
                double x = -gamepad2.right_stick_x * 1.1; // Counteract imperfect strafing
                double rx = -gamepad2.left_stick_x;

                // Denominator is the largest motor power (absolute value) or 1
                // This ensures all the powers maintain the same ratio,
                // but only if at least one is out of the range [-1, 1]
                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
                double frontLeftPower = ((y + x + rx)*s) / denominator;
                double backLeftPower = ((y - x + rx)*s) / denominator;
                double frontRightPower = ((y - x - rx)*s) / denominator;
                double backRightPower = ((y + x - rx)*s) / denominator;

                leftFront.setPower(frontLeftPower);
                leftRear.setPower(backLeftPower);
                rightFront.setPower(frontRightPower);
                rightRear.setPower(backRightPower);

                /////////////////////////////////////////////////////////////

                if (gamepad1.b){
                    k = 1;
                }
                if (gamepad1.a){
                    k = -1;
                }
                if (gamepad1.x){
                    c = c+1;
                    if (c == 1000){
                        drone.setPosition(0.9);
                    }
                } else {
                    drone.setPosition(0.65);
                    c = 0;
                }
                if (gamepad2.y){
                    r = 0.56;
                }
                if (gamepad2.x){
                    r = 0.8;
                }
                if (0.25 <= (b - (k/1000)) && (b - (k/1000)) <= 0.76){
                    b = b - (k/1000);
                }
                arm.setPosition(h);
                hand.setPosition(b);
                riggingsupport.setPosition(r);

            }
        }
    }
}


