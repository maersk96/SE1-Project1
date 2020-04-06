package presentation;


public class Option {

	
	private String name;
	private int inputCount;
	private String[] input;
	private Class<?>[] inputType;
	
	public Option(String name, String[] input, Class<?>[] inputType)
	{
		this.inputCount = input.length;
		int i;
		this.name = name;
		this.input = new String[this.inputCount];
		this.inputType = new Class[this.inputCount];
		for (i=0;i<this.inputCount;i++)
		{
			this.input[i] = input[i];
			this.inputType[i] = inputType[i];
		}
	}
	
	public String GetName() {
		return this.name;
	}
	
	public int GetInputCount() {
		return this.inputCount;
	}
	
	public Option Copy() {
		return new Option(this.name, this.input, this.inputType);
	}
}