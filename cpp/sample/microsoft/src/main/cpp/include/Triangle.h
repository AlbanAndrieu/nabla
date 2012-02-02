/*
 * Triangle.h
 *
 *  Created on: 1 févr. 2012
 *      Author: Alban
 */

#ifndef TRIANGLE_H_
#define TRIANGLE_H_

enum TriangleType{SCALENE, ISOSCELES, EQUILATERAL, ERROR };
/*
#define SCALENE 1
#define ISOSCELES 2
#define EQUILATERAL 3
#define ERROR 4
*/

class Triangle {
public:
	Triangle();
	virtual ~Triangle();

	static int triangleType(const int a, const int b, const int c);

private:
	//TriangleType type;
};

#endif /* TRIANGLE_H_ */
