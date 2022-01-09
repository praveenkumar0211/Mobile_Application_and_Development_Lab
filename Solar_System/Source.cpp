#include<GL/glew.h>
#include<GL/glut.h>

using namespace std;

int x = 0, y = 0;

void disp(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glMatrixMode(GL_MODELVIEW);
	// glColor3f(1,0,0);
	glColor3f(1, 1, 1);

	glPushMatrix();

	glOrtho(-2, 2, -2, 2, -2, 2);
	gluLookAt(0, 0, 1, 0, 0, 0, 0, 1, 0);

	glRotatef(x, 1, 0, 0);
	glRotatef(y, 0, 1, 0);
	glutSolidSphere(0.5, 10, 10);

	gluLookAt(1.3, 0, 0, 0, 0, 0, 0, 1, 0);
	// glColor3f(0,0,1);
	glutSolidSphere(0.2, 10, 10);

	gluLookAt(1.3, 0, 0, 0, 0, 0, 0, 1, 0);
	// glColor3f(0,0,1);
	glutSolidSphere(0.2, 10, 10);

	gluLookAt(1.5, 0, 0, 0, 0, 0, 0, 1, 0);
	// glColor3f(0,1,0);
	glutSolidSphere(0.1, 10, 10);

	glPopMatrix();
	glFlush();
}

void time(int)
{
	y += 1;
	glutPostRedisplay();
	glutTimerFunc(10, time, 0);
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(1000, 1000);
	glutCreateWindow("Circle reflection");

	glClearColor(0, 0, 0, 0);
	glLoadIdentity();
	glMatrixMode(GL_PROJECTION);
	glEnable(GL_DEPTH_TEST);
	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);
	GLfloat lpos[] = { 1.0,1.0,1.0,1.0 };

	glLightfv(GL_LIGHT0, GL_POSITION, lpos);

	glutDisplayFunc(disp);
	glutTimerFunc(10, time, 0);
	glutMainLoop();


}
