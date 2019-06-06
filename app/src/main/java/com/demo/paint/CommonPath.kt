package com.demo.paint

import android.graphics.Path

object CommonPath {
    /**
     * n角星路径
     *
     * @param num 几角星
     * @param R   外接圆半径
     * @param r   内接圆半径
     * @return n角星路径
     */
    fun nStarPath(num: Int, R: Float, r: Float): Path {
        val path = Path()
        val perDeg = (360 / num).toFloat()
        val degA = perDeg / 2f / 2f
        val degB = 360 / (num - 1) / 2 - degA / 2 + degA

        path.moveTo(
            (Math.cos(rad(degA + perDeg * 0).toDouble()) * R + R * Math.cos(rad(degA).toDouble())).toFloat(),
            (-Math.sin(rad(degA + perDeg * 0).toDouble()) * R + R).toFloat()
        )
        for (i in 0 until num) {
            path.lineTo(
                (Math.cos(rad(degA + perDeg * i).toDouble()) * R + R * Math.cos(rad(degA).toDouble())).toFloat(),
                (-Math.sin(rad(degA + perDeg * i).toDouble()) * R + R).toFloat()
            )
            path.lineTo(
                (Math.cos(rad(degB + perDeg * i).toDouble()) * r + R * Math.cos(rad(degA).toDouble())).toFloat(),
                (-Math.sin(rad(degB + perDeg * i).toDouble()) * r + R).toFloat()
            )
        }
        path.close()
        return path
    }

    /**
     * 角度制化为弧度制
     *
     * @param deg 角度
     * @return 弧度
     */
    fun rad(deg: Float): Float {
        return (deg * Math.PI / 180).toFloat()
    }
}
