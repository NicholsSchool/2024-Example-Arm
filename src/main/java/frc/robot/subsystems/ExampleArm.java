package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExampleArm extends SubsystemBase {

  private CANSparkMax armMotor;
  private SparkMaxPIDController armPIDController;

  public ExampleArm() {
    armMotor = new CANSparkMax(Constants.ArmConstants.ARM_CAN_ID, MotorType.kBrushless);
    armMotor.restoreFactoryDefaults();
    armMotor.setIdleMode(IdleMode.kBrake);
    armMotor.setInverted(Constants.ArmConstants.IS_INVERTED);
    armPIDController = armMotor.getPIDController();
    armPIDController.setP(Constants.ArmConstants.ARM_P);
    armPIDController.setI(Constants.ArmConstants.ARM_I);
    armPIDController.setD(Constants.ArmConstants.ARM_D);
    armPIDController.setFF(Constants.ArmConstants.ARM_FF);
  }

  public void spin(double power) {
    armMotor.set(power);
  }

  public void stop() {
    armMotor.stopMotor();
  }

  @Override
  public void periodic() {}
}
