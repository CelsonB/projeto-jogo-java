package Jade;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWErrorCallback;


import java.nio.IntBuffer;

import org.lwjgl.Version;

public class Window {

    //padrão de design SINGLETON, coisa linda

    private int width, height;
    private long glfwWindow; // recebe um long que é o espaço de memoria 
    private String title;

    private static Window window = null ;

    private Window(){
        this.width = 1920;
        this.height = 1080;
        this.title = "mario";
    }

    public static Window getInstance(){

        if(window == null){
            window = new Window();
        }
            return window;
    }


    public void run(){
        System.out.println("hello LWJGl" + Version.getVersion());
        init();
        loop();
       


        
    }

    public void init(){
        GLFWErrorCallback.createPrint(System.err).set();
        
        if(!glfwInit()){
            throw new IllegalStateException("Falha ao inicializar GLFW.");
        }
        glfwDefaultWindowHints();

        
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        
        	// Create the window
		glfwWindow = glfwCreateWindow(this.width, this.width, this.title, NULL, NULL);
		if ( glfwWindow == NULL ) throw new RuntimeException("Failed to create the GLFW window");


        /**
         * os callback do mouse listener ficaram aqui
         */

        glfwSetCursorPosCallback(glfwWindow, MouseListener:: mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener:: mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);
        





		glfwMakeContextCurrent(glfwWindow);
        glfwSwapInterval(1); //vsinc??  

        glfwShowWindow(glfwWindow);

        
        GL.createCapabilities();
         

		
		

    }

    public void loop(){
        while(!glfwWindowShouldClose(glfwWindow)){

            glfwPollEvents();
            glClearColor(1.0f, 1.0f, 1.0f,1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(glfwWindow);



        }
    }
}
