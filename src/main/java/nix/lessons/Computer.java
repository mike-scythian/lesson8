package nix.lessons;

import org.json.JSONObject;

import java.util.Scanner;
import java.util.UUID;

public class Computer {
  private int ram;
  private int cores;
  private String name;
  private UUID number;
  private OperatingSystem operatingSystem;

  public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
    this.ram = ram;
    this.cores = cores;
    this.name = name;
    this.operatingSystem = operatingSystem;
    this.number = UUID.randomUUID();
  }

  public static ComputerBuilder builder() {
    return new ComputerBuilder();
  }

  @Override
  public String toString() {
    return "Computer{" +
        "ram=" + ram +
        ", cores=" + cores +
        ", name='" + name + '\'' +
        ", number=" + number +
        ", operatingSystem=" + operatingSystem +
        '}';
  }
//-------------------------------------------------------------------------------------------------------
  public void deathScreen(){

    Scanner readReload = new Scanner(System.in);
    do {
      System.out.print("BLUE SCREEN! YOU NEED RELOAD YOUR SYSTEM!\t");
    } while(!readReload.next().equalsIgnoreCase("RELOAD"));

  }

  public JSONObject summaryInfo(){

   JSONObject json = new JSONObject();
   json.put("name", this.name)
           .put("cores", this.cores)
           .put("ram", this.ram)
           .put("os", this.operatingSystem);

   return json;
  }

  public boolean isWorkable(){

    switch (this.operatingSystem){
      case Windows -> {return this.ram >= 2;}
      case MacOS ->   {return this.ram >= 4;}
      case Linux ->   {return this.ram >= 1;}
      default ->      {return false;}
    }
  }

  public int speedOfProcessing(int volumeInformation){

    if(!isWorkable() || volumeInformation == 0)
      return 0;
    if(volumeInformation < 1024)
      return this.ram * this.cores * volumeInformation;
    return (this.ram * this.cores * 1024) / volumeInformation;
  }

//------------------------------------------------------------------------------------------------------------
  public static class ComputerBuilder {
    private int ram;
    private int cores;
    private String name;
    private UUID number;
    private OperatingSystem operatingSystem;

    public ComputerBuilder ram(int ram) {
      this.ram = ram;
      return this;
    }

    public ComputerBuilder cores(int cores) {
      this.cores = cores;
      return this;
    }

    public ComputerBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ComputerBuilder number() {
      this.number = UUID.randomUUID();
      return this;
    }

    public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
      this.operatingSystem = operatingSystem;
      return this;
    }

    public Computer build() {
      return new Computer(ram, cores, name, operatingSystem);
    }
  }

}
