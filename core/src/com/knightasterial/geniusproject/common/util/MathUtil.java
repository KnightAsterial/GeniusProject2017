package com.knightasterial.geniusproject.common.util;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;


public class MathUtil {
	
	//temp vector = center, just to save memory
	public static boolean overlaps(Polygon polygon, Circle circle, Vector2 tempVector) {
	    float []vertices=polygon.getTransformedVertices();
	    tempVector.set(circle.x, circle.y);
	    float squareRadius=circle.radius*circle.radius;
	    for (int i=0;i<vertices.length;i+=2){
	        if (i==0){
	            if (Intersector.intersectSegmentCircle(new Vector2(vertices[vertices.length - 2], vertices[vertices.length - 1]), new Vector2(vertices[i], vertices[i + 1]), tempVector, squareRadius))
	                return true;
	        } else {
	            if (Intersector.intersectSegmentCircle(new Vector2(vertices[i-2], vertices[i-1]), new Vector2(vertices[i], vertices[i+1]), tempVector, squareRadius))
	                return true;
	        }
	    }
	    return polygon.contains(circle.x, circle.y);
	}
}
