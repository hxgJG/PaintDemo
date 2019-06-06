# PaintDemo
关于Paint的使用

三种线帽比较: Paint.Cap.BUTT、Paint.Cap.ROUND、Paint.Cap.SQUARE
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/1.png)

角型比较：Paint.Join.BEVEL、Paint.Join.ROUND、Paint.Join.MITER
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/2.png)

圆角折线
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/3.png)

离散路径
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/4.png)

路径点样：PathDashPathEffect(路径,间距，偏移，样式)
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/5.png)

路径叠加
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/6.png)

new LinearGradient(渐变起点x，y,渐变终点x,y,渐变色1，渐变色2，渐变模式)
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/7.png)

多色多点渐变：LinearGradient(渐变起点x，y,渐变终点x,y,颜色数组，位置百分点数组0~1,渐变模式)
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/8.png)

两色渐变：RadialGradient(渐变中心，渐变半径，颜色1，颜色2，渐变模式)
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/9.png)

扫描渐变：SweepGradient
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/10.png)

文字的图片底色
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/11.png)

路径+图片着色器实现裁剪图片
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/12.png)

颜色过滤器:LightingColorFilter(颜色1，颜色2)
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/13.png)

颜色过滤器:PorterDuffColorFilter(颜色，模式--PorterDuff.Mode)
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/14.png)

颜色过滤器:ColorMatrixColorFilter(颜色变换矩阵或25个float数)
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/15.png)

创建字体：外部字体放在assets目录下
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/16.png)

文字的测量：FontMetrics
	SERIF字体测试：
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/17.png)

获取文字矩形区
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/18.png)

文字的变形操作
![头像](https://github.com/hxgJG/PaintDemo/blob/master/result_images/19.png)