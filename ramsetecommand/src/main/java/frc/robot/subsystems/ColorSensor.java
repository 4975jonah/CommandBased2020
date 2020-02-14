package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;

public class ColorSensor extends SubsystemBase {
    public Color previousColor;
    public Color detectedColor;
    public String gameData;
    public int colorPasses;
    public int rotations;
    public Color colorGoal;
    /**
    * Change the I2C port below to match the connection of your color sensor
    */
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

    public String getFieldColor() {
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0) {
            System.out.println("Game data received, updating color wheel data.");
        } else {
            //Code for no data received yet
            System.out.println("No Control Panel data has been received yet.");
        }
        return gameData;
    }

    public void checkColor() {
        previousColor = detectedColor;
        detectedColor = m_colorSensor.getColor();
        System.out.println("Blue: " + detectedColor.blue + "  Green: " + detectedColor.green + "  Red: " + detectedColor.red);
    }
}