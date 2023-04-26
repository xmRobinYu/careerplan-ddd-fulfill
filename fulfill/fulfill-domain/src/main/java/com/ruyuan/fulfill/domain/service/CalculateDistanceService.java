package com.ruyuan.fulfill.domain.service;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 计算距离Service
 * @author zhonghuashishan
 * @version 1.0
 */
@Component
public class CalculateDistanceService {

    /**
     * 计算两个经纬度之间单直线距离
     * @param srcLon
     * @param srcLat
     * @param destLon
     * @param destLat
     * @return
     */
    public double getDirectDistance(BigDecimal srcLon, BigDecimal srcLat, BigDecimal destLon, BigDecimal destLat) {
        GlobalCoordinates source = new GlobalCoordinates(srcLon.doubleValue(), srcLat.doubleValue());
        GlobalCoordinates target = new GlobalCoordinates(destLon.doubleValue(), destLat.doubleValue());

        return getDistanceMeter(source, target, Ellipsoid.Sphere);
    }


    private double getDistanceMeter(GlobalCoordinates gpsFrom, GlobalCoordinates gpsTo, Ellipsoid ellipsoid){

        // 创建GeodeticCalculator，调用计算方法，传入坐标系、经纬度用于计算距离
        GeodeticCurve geoCurve = new GeodeticCalculator().calculateGeodeticCurve(ellipsoid, gpsFrom, gpsTo);

        return geoCurve.getEllipsoidalDistance();
    }

}
