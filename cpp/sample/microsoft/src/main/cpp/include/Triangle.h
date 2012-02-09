/*
 * Triangle.h
 *
 */
#pragma once
#ifndef TRIANGLE_H_
#define TRIANGLE_H_

enum TriangleType{SCALENE, ISOSCELES, EQUILATERAL, ERROR };

class Triangle {
public:
	Triangle();
	virtual ~Triangle();

	static const int triangleType(const int a, const int b, const int c);

private:
	//TriangleType type;
};

#endif /* TRIANGLE_H_ */
