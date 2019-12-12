package BackWord;



public class dictNode {
	private String name;
	private int similarity;



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSimilarity() {
		return similarity;
	}
	public void setSimilarity(int similarity) {
		this.similarity = similarity;
	}
	
	
//	@Override
//    public float compareTo(dictNode comparestu) {
//        float compareAge=((dictNode)comparestu).getSimilarity();
//        /* ÕıĞòÅÅÁĞ */
//        return this.age-compareAge;
//
//        /* ÄæĞòÅÅÁĞ */
//        //return compareAge-this.age;
//    }



}
