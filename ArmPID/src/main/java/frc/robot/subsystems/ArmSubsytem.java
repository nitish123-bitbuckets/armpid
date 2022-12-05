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

    WPI_TalonSRX[] arms = {rightArm, leftArm};

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
            for(int i = 0; i < 2; i++){
                arms[i].config_kP(0, KP);
                arms[i].config_kI(0, KI);
                arms[i].config_kD(0, KD);
                arms[i].configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
                arms[i].setSensorPhase(true);
                arms[i].configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
            }

            MoveArm1();
            MoveArm2();
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

