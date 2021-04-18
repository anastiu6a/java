package ru.lessons.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testDistance1() {
    Point p1 = new Point(1,1);
    Point p2 = new Point(1,2);
    Assert.assertEquals(p1.distance(p2), 1.0);
  }
  @Test
  public void testDistance2() {
    Point p1 = new Point(5,7);
    Point p2 = new Point(1,2);
    Assert.assertEquals(p1.distance(p2), 6.4031242374328485);
  }
  @Test
  public void testDistance3() {
    Point p1 = new Point(-5,7);
    Point p2 = new Point(1,2);
    Assert.assertEquals(p1.distance(p2), 7.810249675906654);
  }
  @Test
  public void testDistance4() {
    Point p1 = new Point(0,1);
    Point p2 = new Point(0,1);
    Assert.assertEquals(p1.distance(p2), 0);
  }
}
