package com.openglexample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.os.SystemClock;

public class Triangle {

	private FloatBuffer vertexBuffer; 

	private float vertices[] = { 
			-0.5f, 0f, 0f,
			0.5f, 0f, 0f,
			0.0f, 1.5f, 0f};

	private boolean motion = false;

	public Triangle() {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length
				* Float.SIZE);
		byteBuffer.order(ByteOrder.nativeOrder());

		vertexBuffer = byteBuffer.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);

	}

	public void draw(GL10 gl) {
		gl.glPushMatrix();
		if (motion) {
			long time = SystemClock.uptimeMillis() % 4000L;
			float angle = 0.090f * ((int) time);
			gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
		}

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glColor4f(0.0f, 0.75f, 0.0f, 1.0f);
		gl.glFrontFace(GL10.GL_CW); // ?
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
        gl.glPopMatrix();
	}
}
