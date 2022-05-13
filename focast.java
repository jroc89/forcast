import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Forecast {
    private double temp = 72.0;
    private String skyCondition = "clear";
    private int rain = 0;

    public Forecast() {

    }

    public Forecast(double temp, String skyCondition, int rain) {
        setTemp(temp);
        setSkyCondition(skyCondition);
        setRain(rain);
    }

    public double getTemp() {
        return temp;
    }

    public String getSkyCondition() {
        return skyCondition;
    }

    public int getRain() {
        return rain;
    }

    public void setTemp(double temp) {
        if (temp >= -100 && temp <= 150)
            this.temp = temp;
        else
            this.temp = 72.0;
    }

    public void setRain(int rain) {
        if (rain >= 0 && rain <= 100)
            this.rain = rain;
        else
            this.rain = 0;
    }

    public void setSkyCondition(String skyCondition) {
        this.skyCondition = skyCondition;
    }

    public double FToCel(double f) {
        return 5.0 / 9.0 * (f - 32);
    }

    public double CelToF(double Cel) {
        return 9.0 / 5.0 * (Cel) + 32;
    }

    public double FeToK(double f) {
        return 5.0 / 9.0 * (f - 32) + 273;
    }

    public double KToFe(double k) {
        return 9.0 / 5.0 * (k - 273) + 32;
    }

    public String toString() {
        return "Forecast temp=" + temp + " rain=" + rain + "% skyCondtion=" + skyCondition + "\n";

    }

    public boolean isItRaining(int rain) {

        if (rain >= 50) {

            return true;

        } else {

            return false;

        }
    }

    // create a new method called print
    public void print() {

        System.out.println("\nWheather conditions: Temperature outside is " + temp + " degrees with chance of rain is "
                + rain + "% and " + skyCondition);

        PrintWriter printer = null;
        try {
            printer = new PrintWriter("Forecast.txt");
            printer.println("Temperture = " + temp);
            printer.println("Sky Condition = " + skyCondition);
            printer.println("Chances of rain = " + rain);
            printer.println("Temperature in Celsius = " + FToCel(temp));
            printer.println("Temperature in Fahrenheit = " + CelToF(temp));
            printer.println("Temperature in Kelvin = " + FeToK(temp));
            printer.println("\nWheather conditions: Temperature outside is " + temp + " degrees with chance of rain is "
                    + rain + "% and " + skyCondition);

            printer.close();
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
            fe.printStackTrace();
        } catch (IOException exec) {
            System.out.println("Error file IO exception");
            
        } catch (Exception exception) {
            System.out.println("Exception Error");
            
        }
    }
}
