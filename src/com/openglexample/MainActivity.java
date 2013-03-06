package com.openglexample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;

public class MainActivity extends Activity implements Renderer{

	private static final int Coordinates_In_A_Vertex = 2;
    private static final int Vertices_In_A_Triangle = 3;
    private static final int Bits_In_A_Byte = 8;
    private static final int Bits_In_A_Float = Float.SIZE;
    private static final int Bytes_In_A_Float = Bits_In_A_Float / Bits_In_A_Byte;
     
    private GLSurfaceView glSurfaceView;
    private FloatBuffer vertices;
    private int width;
    private int height;
	private Triangle t;
	float angle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		// Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
		glSurfaceView = new GLSurfaceView(this);
		glSurfaceView.setRenderer(this);
        setContentView(glSurfaceView);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		glSurfaceView.onPause();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		glSurfaceView.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glColor4f(0.64313725490196f, 0.77647058823529f, 0.22352941176471f, 1);
        //gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertices);
        //gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        t.draw(gl);
        /*// Save the current matrix.
    	gl.glPushMatrix();
    	// Rotate square A counter-clockwise.
    	//gl.glTranslatef(1, 0, 0);
    	// Draw 
    	t.draw(gl);
    	// Restore the last matrix.
    	gl.glPopMatrix();
    	
    	 // Save the current matrix.
    	gl.glPushMatrix();
    	// Rotate square A counter-clockwise.
    	//gl.glTranslatef(-1, 0, 0);
    	// Draw square A.
    	t.draw(gl);
    	// Restore the last matrix.
    	gl.glPopMatrix();*/
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		 float ratio = (float) width / height;
		 gl.glMatrixMode(GL10.GL_PROJECTION); // set matrix to projection mode
		 gl.glLoadIdentity(); // reset the matrix to its default state
		 gl.glFrustumf(-ratio, ratio, -1, 1, 3, 7);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		GLU.gluLookAt(gl, 0, 0, 5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        
        width = glSurfaceView.getWidth();
        height = glSurfaceView.getHeight();
         
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        
        t = new Triangle();
        
        gl.glLoadIdentity();
        gl.glOrthof(0, 1, 0, 1, 1, -1);
        gl.glClearColor(1f, 1f, 1f, 1);
         
        /*ByteBuffer byteBuffer = ByteBuffer.allocateDirect(9 * Bytes_In_A_Float);
        byteBuffer.order(ByteOrder.nativeOrder());
         
        vertices = byteBuffer.asFloatBuffer();
         
        vertices.put(new float[]
                { 
                    -1.0f, 0.0f, 0.0f,
                    0.0f, 1.0f, 0.0f,
                    0.0f, 0.0f, 1.0f
                }
        );
         
        vertices.flip();
        
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);*/
        
        
	}

}
