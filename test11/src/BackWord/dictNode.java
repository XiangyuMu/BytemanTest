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
//        /* �������� */
//        return this.age-compareAge;
//
//        /* �������� */
//        //return compareAge-this.age;
//    }



}
