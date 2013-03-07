package com.openglexample;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity implements Renderer{

    private GLSurfaceView glSurfaceView;
    private int width;
    private int height;
	private Triangle triangle;
	private Axis axis;
	float angle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		glSurfaceView = new GLSurfaceView(this);
		glSurfaceView.setRenderer(this);
        setContentView(glSurfaceView);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		glSurfaceView.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		glSurfaceView.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
    	triangle.draw(gl);
    	axis.draw(gl);
    	
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluLookAt(gl, 0, 0, 5,  0f, 0f, 0f, 0f, 1.0f, 0.0f);
        
        width = glSurfaceView.getWidth();
        height = glSurfaceView.getHeight();
        
        GLU.gluPerspective(gl, 60.0f, width / height , -10.0f, 1000.0f);
         
        
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glViewport(0, 0, width, height);
        
        triangle = new Triangle();
        axis = new Axis();
        
        gl.glClearColor(1f, 1f, 1f, 1);
	}

}
