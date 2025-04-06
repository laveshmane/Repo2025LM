package bdd.cucumberAPI;

public class payload {
public static String  Addplace() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 7,\r\n"
				+ "  \"name\": \"lavesh house valase\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"Satara Palace IND 007\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://satara.com\",\r\n"
				+ "  \"language\": \"Marathi-IN\"\r\n"
				+ "}";
	}

public static String qraphQLquery() {
	return "{\"query\":\"\\nquery($country:String! $epId:Int!)\\n\\n{\\n  locations(filters:{name:$country}){\\n    info{\\n      count\\n      pages\\n      next\\n      prev\\n    }\\n    result{\\n      id\\n      name\\n      type\\n      dimension\\n      \\n    }\\n  }\\n  episode(episodeId: $epId){\\n    id\\n    name\\n    air_date\\n    episode\\n    created\\n    \\n  }\\n}\",\"variables\":{\"country\":\"America\",\"epId\":432}}";
}

public static String graphQLmutation() {
	return "{\"query\":\"mutation ($episode: String!, $location: String!) {\\n  createEpisode(episode: {name: $episode, air_date: \\\"Today\\\", episode: \\\"1\\\"}) {\\n    id\\n  }\\n  createLocation(location: {name: $location, type: \\\"Cartoon\\\", dimension: \\\"very big\\\"}) {\\n    id\\n  }\\n  deleteLocations(locationIds: [23, 32, 43, 543, 53]) {\\n    locationsDeleted\\n  }\\n}\\n\",\"variables\":{\"episode\":\"The american pie\",\"location\":\"california\"}}";
}
}
