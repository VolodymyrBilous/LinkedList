
public class Buss {
    public int bussNumber;
    public String driverName;
    public int routeNumber;
    public Buss next;
    
	public Buss(int bussNumber,int routeNumber,String driverName) {
		this.bussNumber = bussNumber;
		this.driverName = driverName;
		this.routeNumber = routeNumber;
		next = null;
	}
    public String getName(){
    	return "buss # "+bussNumber+",routeNumber #"+routeNumber+",driver name"+driverName;
    }
}
