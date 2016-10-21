package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.matrix.MatrixDcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoController;

/**
 * Created by 226486 on 10/21/16.
 */

public class Black_HardwareMatrix extends Black_Hardware
{
    /* Public OpMode members. */
    private MatrixDcMotorController matrixMotorController = null;
    private ServoController matrixServoController = null;

    /* Constructor */
    public Black_HardwareMatrix(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap bhwMap) {

        // Initialize base Motor and Servo objects
        super.init(bhwMap);

        /*
         * Matrix controllers are special.
         *
         * A Matrix controller is one controller with both motors and servos
         * but software wants to treat it as two distinct controllers, one
         * DcMotorController, and one ServoController.
         *
         * We accomplish this by initializing Motor and Servo controller with the same name
         * given in the configuration.  In the example below the name of the controller is
         * "MatrixController"
         *
         * Normally we don't need to access the controllers themselves, we deal directly with
         * the Motor and Servo objects, but the Matrix interface is different.
         *
         * In order to activate the servos, they need to be enabled on the controller with
         * a call to pwmEnable() and disabled with a call to pwmDisable()
         *
         * Also, the Matrix Motor controller interface provides a call that enables all motors to
         * updated simultaneously (with the same value).
         */

        // Initialize Matrix Motor and Servo objects
        matrixMotorController = (MatrixDcMotorController)bhwMap.dcMotorController.get("matrix controller");
        matrixServoController = bhwMap.servoController.get("matrix controller");

        // Enable Servos
        matrixServoController.pwmEnable();       // Don't forget to enable Matrix Output
    }
}
