public class Corgi extends Dog {

	public void bark(Corgi c) {
		System.out.println("B!");
	}
	@Override
	public void bark(Dog d) {
		System.out.println("C!");
	}

	public void play(Dog d) {
		System.out.println("D!");
	}

	public void play(Corgi c) {
		System.out.println("E!");
	}

	public static void main(String[] args) {
		Dog d = new Corgi();
		Corgi c = new Corgi();

		/**Corgi 可以用 bark(Corgi c) bark(Dog d) play(Corgi c) play(Dog d);
		 * Dog可以用bark(Dog d)
		 * */
		//d.play(d);//编译错误，Dog里没有play()
		//d.play(c);//编译错误，Dog里没有play()

		c.play(d);//D!
		c.play(c);//E!

		c.bark(d);//C!
		c.bark(c);//B!

		d.bark(d);//C
		d.bark(c);//运行时错，需要Dog类不能是Corgi类  C
	}
}