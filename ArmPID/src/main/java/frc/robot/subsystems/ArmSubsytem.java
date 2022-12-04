package frc.robot.subsystems;




import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ArmSubsytem extends SubsystemBase {

    WPI_TalonSRX leftArm = new WPI_TalonSRX(1);
    WPI_TalonSRX rightArm = new WPI_TalonSRX(2);

    public double KP;
    public double KI;
    public double KD;

    public ArmSubsytem(double kP, double kI, double kD) {
        KP = kP;
        KI = kI;
        KD = kD;
    }
    public void MoveArm1() {
        leftArm.set(ControlMode.Position, 20033);
    }

    public void MoveArm2() {
        rightArm.set(ControlMode.Position, 19868);
    }

    boolean isRobotOn = false;

    @Override
    public void periodic() {
        if (isRobotOn = false) {
            rightArm.config_kP(0, KP);
            rightArm.config_kD(0, KD);
            rightArm.config_kI(0, KI);
            rightArm.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
            rightArm.setSensorPhase(true);
            rightArm.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);


            leftArm.config_kI(0, 0);
            leftArm.config_kD(0, 0);
            leftArm.config_kP(0, 0);
            leftArm.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
            leftArm.setSensorPhase(true);
            leftArm.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);




            MoveArm2();
            MoveArm1();
            isRobotOn = true;
        }

    }






    public double getKP() {
        return KP;
    }
    public double getKI() {
        return KI;
    }
    public double getKD() {
        return KD;
    }
}

