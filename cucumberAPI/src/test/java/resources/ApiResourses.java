package resources;
//Enum is a special class which stores the collections of methods and collections of constants
public enum ApiResourses {

	postAPIResource("maps/api/place/add/json"),
	getAPIResource("maps/api/place/get/json"),
	deleteAPIResource("maps/api/place/delete/json");
	
	String resource;
    ApiResourses(String resource){
		this.resource = resource;
	}
     
    public String getResource() {
    	return resource;
    }
}
