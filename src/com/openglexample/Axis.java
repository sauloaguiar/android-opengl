package com.openglexample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Axis {
	private FloatBuffer xBuffer, yBuffer, zBuffer; // buffer holding vertices

	private float x[] = { 
			1.0f, 0.0f, 0.0f};
	
	private float y[] = { 
			0.0f, 1.0f, 0.0f};

	private float z[] = { 
			0.0f, 0.0f, 1.0f};

	public Axis() {
		ByteBuffer xbyteBuffer = ByteBuffer.allocateDirect(x.length * Float.SIZE);
		xbyteBuffer.order(ByteOrder.nativeOrder());

		xBuffer = xbyteBuffer.asFloatBuffer();
		xBuffer.put(x);
		xBuffer.position(0);
		
		ByteBuffer ybyteBuffer = ByteBuffer.allocateDirect(y.length * Float.SIZE);
		ybyteBuffer.order(ByteOrder.nativeOrder());

		yBuffer = ybyteBuffer.asFloatBuffer();
		yBuffer.put(y);
		yBuffer.position(0);
		
		ByteBuffer zbyteBuffer = ByteBuffer.allocateDirect(z.length * Float.SIZE);
		zbyteBuffer.order(ByteOrder.nativeOrder());
		
		zBuffer = zbyteBuffer.asFloatBuffer();
		zBuffer.put(z);
		zBuffer.position(2);
	}
	
	public void draw(GL10 gl){
		gl.glPushMatrix();
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
	    gl.glLoadIdentity();
	    gl.glLineWidth(1f);
	    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	    
	    // X
	    gl.glVertexPointer(2, GL10.GL_FLOAT, 0, xBuffer);
	    gl.glColor4f(0f, 0f, 1f, 0.5f);
	    gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);
	    gl.glDrawElements(GL10.GL_LINES, 1, GL10.GL_UNSIGNED_BYTE, xBuffer);
	    
	    /// Y
	    gl.glVertexPointer(2, GL10.GL_FLOAT, 0, yBuffer);
	    gl.glColor4f(0f, 1f, 0f, 0.5f);
	    gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);
	    gl.glDrawElements(GL10.GL_LINES, 1, GL10.GL_UNSIGNED_BYTE, yBuffer);
	    
	    // Z
	    gl.glVertexPointer(2, GL10.GL_FLOAT, 0, zBuffer);
	    gl.glColor4f(1f, 0f, 0f, 0.5f);
	    gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);
	    gl.glDrawElements(GL10.GL_LINES, 1, GL10.GL_UNSIGNED_BYTE, zBuffer);
	    
	    gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	    gl.glPopMatrix();
	}
}
