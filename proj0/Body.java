import static java.lang.Math.sqrt;
public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/**计算两个Body之间距离的方法calcDistance*/
	public double calcDistance(Body b1){
		double r = (this.xxPos-b1.xxPos)*(this.xxPos-b1.xxPos)+
			(this.yyPos-b1.yyPos)*(this.yyPos-b1.yyPos);
		return java.lang.Math.sqrt(r);

	}

	/**
	计算给定物体施加在该物体上的力，方法calcForceExertedBy
	*/
	public static double g = 6.67e-11;
	public double calcForceExertedBy(Body b2){
		double f = g*this.mass*b2.mass/(this.calcDistance(b2)*this.calcDistance(b2));
		return f;
	}

	/**
	计算给定物体施加在该物体上的力沿X轴方向的分量，
	*fx = f*dx/r
	*方法calcForceExertedByX
	*/
	public double calcForceExertedByX(Body b2){
		double fx = this.calcForceExertedBy(b2)*(b2.xxPos-this.xxPos)/this.calcDistance(b2);
		return fx;
	}


	/**
	计算给定物体施加在该物体上的力沿Y轴方向的分量，
	*fy = f*dy/r
	*方法calcForceExertedByY
	*/
	public double calcForceExertedByY(Body b2){
		double fy = this.calcForceExertedBy(b2)*(b2.yyPos-this.yyPos)/this.calcDistance(b2);
		return fy;
	}

	/**计算施加的netX和netY
	*netX=f1x+f2x+f3x+...
	*方法calcNetExertedByX和calcNetExertedByY
	*/
	//public Body[] allBodys;
	
	public double calcNetForceExertedByX(Body[] allBodys){
		double netX = 0.0;
		for(int i = 0;i  < allBodys.length;i++){
			Body bi = allBodys[i];
			if(this.equals(bi)){
				continue;
			}
			netX = netX + this.calcForceExertedByX(bi);
		}
		return netX; 
	}

	
	public double calcNetForceExertedByY(Body[] allBodys){
		double netY = 0.0;
		for(int i = 0;i  < allBodys.length;i++){
			Body bi = allBodys[i];
			if(this.equals(bi)){
				continue;
			}
			netY = netY + this.calcForceExertedByY(bi);
		}
		return netY; 
	}

	/**
	*更新身体的位置和速度
	*update
	*/
	public void update(double dt, double fX, double fY){
		
		double aX = fX/this.mass;
		double aY = fY/this.mass;
		xxVel = xxVel + aX * dt;
		yyVel = yyVel + aY * dt;
		xxPos = xxPos + xxVel * dt;
		yyPos = yyPos + yyVel * dt;
	}

	public void draw(){		
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);		
	}
}