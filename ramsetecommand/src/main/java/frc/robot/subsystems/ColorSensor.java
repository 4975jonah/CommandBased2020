package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;

public class ColorSensor extends SubsystemBase {
    public String previousColor;
    public Color detectedColor;
    public String detectedColorString;
    public String colorGuess;
    public String gameData;
    public int colorPasses;
    public int rotations;
    public Color colorGoal;
    
    public char redColor;
    public char greenColor;
    public char blueColor;
    /**
    * Change the I2C port below to match the connection of your color sensor.
    */
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

    //Getting the color we need to align the Control Panel to from the Field Management System.
    public String getFieldColor() {
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0) {
            System.out.println("Game data received, updated Control Panel data.");
        } else {
            //Code for no data received yet
            System.out.println("No Control Panel data has been received yet.");
        }
        return gameData;
    }
    //gets the current color the sensor detects, and prepares for converting it from hexadecimal.
    public void checkColor() {
        //Bringing in the color from the sensor.
        previousColor = colorGuess;
        detectedColor = m_colorSensor.getColor();
        detectedColorString = detectedColor.toString();

        //Spliting the Hexidecimal into three variables for the respective color to avoid repetitive .charAt() statements.
        redColor = detectedColorString.charAt(1);
        greenColor = detectedColorString.charAt(3);
        blueColor = detectedColorString.charAt(5);


        //System.out.println("Blue: " + detectedColor.blue + "  Green: " + detectedColor.green + "  Red: " + detectedColor.red);
    }
    //Checking the first, third, and fith letters of  the color hexidecimal(corosponding to the red, green and blue) to see which values are high, in order to guess the color.
    public void checkRedYellow() {
        if (redColor == 'D' || redColor == 'E' || redColor == 'F') {
            if (greenColor == 'D' || greenColor == 'E' || greenColor == 'F') {
                colorGuess = "Yellow";
                System.out.println("Yellow. Because Red and Green are both high values");
            } else {
                colorGuess = "Red";
                System.out.println("Red. It is a high vallue.");
            }
        }
    }
    
    public void checkGreen() {
        if (greenColor == 'D' || greenColor == 'E' || greenColor == 'F') {
            if (colorGuess != "Yellow") {
                colorGuess = "Green";
                System.out.println("Green. It is a high value");
            }
        }
    }

    public void checkBlue() {
       if (blueColor == 'D' || blueColor == 'E' || blueColor == 'F') {
           colorGuess = "Blue";
           System.out.println("Blue. It is a high value");
       }
    }
    
}