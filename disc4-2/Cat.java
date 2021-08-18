public class Cat extends Animal {
	public void bark() {
		System.out.println("Cat!");
	}

	public static void main (String[] args) {
		//Cat c = new Animal();//编译错误，Cat是Animal的子类
		Animal a = new Cat();//正常运行
		//Dog d = new Cat();//编译错误，Cat与Dog无关
		//Tree t = new Animal();//编译错误，Tree与Animal无关

		//Animal a = (Cat)new Cat();//正常运行,上边已经定义过变量a,为什么答案上显示没错误
		//Animal a = (Animal) new Cat();//我不知道
		Dog d = (Dog) new Animal();//正常运行
		//Cat c = (Cat) new Dog();//运行时出错，纠正为编译时出错，无法转换
		//Animal a = (Animal) new Tree();//运行时出错，两个类就没关系.纠正：编译时出错，类无法转换
	}
}