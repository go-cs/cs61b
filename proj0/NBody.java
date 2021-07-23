public class NBody{
	/**
	 * 读取文件中宇宙半径
	 * */
	public static double readRadius(String filename){
		In in = new In(filename);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	/**
	 * 读取行星*/
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int planetsNumber = in.readInt();
		in.readDouble();
		Planet[] planets = new Planet[planetsNumber];
		int i = 0;
		while(i < planetsNumber){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i++] = new Planet(xP, yP, xV, yV, m, img);
		}
		return planets;
	}
	

	/**
	 * 绘制初始宇宙状态*/
	public static void main(String[] args){
		//收集所有需要的输入
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double uniRadius = NBody.readRadius(filename);
		Planet[] star = NBody.readPlanets(filename);
		double time = 0.0;
		/**
		 * 防止动画闪烁*/
		StdDraw.enableDoubleBuffering();
		/**
		//绘制背景
		StdDraw.setScale(-uniRadius,uniRadius);
		StdDraw.clear();
		String imageToDraw = "images/starfield.jpg";
		StdDraw.picture(0,0,imageToDraw);
		StdDraw.show();
		//绘制多个身体
		In in = new In(filename);
		int num = in.readInt();
		for (int i = 0; i < num ;i++ ) {
			star[i].draw();			
		}
		*/
		while(time <= T){
			double[] xForces = new double[star.length];
			double[] yForces = new double[star.length];
			for (int i = 0;i < star.length ;i++ ) {
				xForces[i] = star[i].calcNetForceExertedByX(star);
				yForces[i] = star[i].calcNetForceExertedByY(star);
			}
			for (int i = 0;i < star.length ;i++ ) {
				star[i].update(dt,xForces[i],yForces[i]);
				
			}
			/**绘制背景图*/
			StdDraw.enableDoubleBuffering();
			StdDraw.setScale(-uniRadius,uniRadius);
			StdDraw.clear();
			String imageToDraw = "images/starfield.jpg";
			StdDraw.picture(0,0,imageToDraw);
			StdDraw.show();
			/**绘出所有行星*/
			for (int i = 0; i < star.length ;i++ ) {
				star[i].draw();			
			}
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;			
		}//while

		/**打印输出宇宙最终状态*/
		StdOut.printf("%d\n",star.length);
		StdOut.printf("%7.2e\n",uniRadius);
		for (int i = 0;i < star.length ;i++ ) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
							star[i].xxPos,star[i].yyPos,star[i].xxVel,
							star[i].yyVel,star[i].mass,star[i].imgFileName);
		}
		
		
	}
	
}