package com.demo.paint

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi

class PaintView : View {
    private val mRedPaint = Paint()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas ?: return
        mRedPaint.color = resources.getColor(R.color.colorAccent)
//        testStyle(canvas)
//        drawPos(canvas)
//        testOfCap(canvas)
//        testOfJoin(canvas)
//        dashEffect(canvas)
//        cornerEffect(canvas)
//        discreteEffect(canvas)
//        PathDashEffect(canvas)
//        composeEffect(canvas)
//        sumEffect(canvas)
//        test1(canvas)
//        test2(canvas)
//        test3(canvas)
//        test4(canvas)
//        test5(canvas)
//        test6(canvas)
//        test7(canvas)
//        test8(canvas)
//        test9(canvas)
//        test10(canvas)
//        test11(canvas)
//        test12(canvas)
//        test13(canvas)
//        test14(canvas)
        test15(canvas)
    }

    /**
     * 一、画笔的常规配置
     * public void setColor(@ColorInt int color) //设置颜色
     * public void setAlpha(int a)//设置透明度
     * public void setARGB(int a, int r, int g, int b)//设置ARGB颜色
     * public void setStrokeWidth(float width)//设置宽度
     * public void setAntiAlias(boolean aa)//设置抗锯齿
     */

    /**
     * 二、笔的样式：Paint.Style.：[#FILL|STROKE|FILL_AND_STROKE]
     */

    //样式测试
    private fun testStyle(canvas: Canvas) {

        val rect = Rect(0, 0, 100, 100)
        mRedPaint.strokeWidth = 15f
        canvas.save()

        mRedPaint.style = Paint.Style.FILL
        canvas.translate(50f, 450f)
        canvas.drawRect(rect, mRedPaint)

        canvas.translate(150f, 0f)
        mRedPaint.style = Paint.Style.STROKE
        canvas.drawRect(rect, mRedPaint)

        canvas.translate(150f, 0f)
        mRedPaint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawRect(rect, mRedPaint)
        canvas.restore()
        mRedPaint.strokeWidth = 40f
    }

    /**
     * 三、线帽：Paint.Cap.：[#BUTT|ROUND|SQUARE]
     */

    // 1.绘制圆形的点
    private fun drawPos(canvas: Canvas) {
        //设置画笔圆帽
        mRedPaint.strokeCap = Paint.Cap.ROUND
        mRedPaint.strokeWidth = 20f
        //绘制点
        canvas.drawPoint(100f, 100f, mRedPaint)
        canvas.drawPoints(
            floatArrayOf(400f, 400f, 500f, 500f, 600f, 400f, 700f, 350f, 800f, 300f, 900f, 300f),
            mRedPaint
        )
    }

    // 2.三种线帽比较
    // 线帽型状测试：Paint.Cap.BUTT、Paint.Cap.ROUND、Paint.Cap.SQUARE
    private fun testOfCap(canvas: Canvas) {
        mRedPaint.strokeWidth = 50f
        canvas.save()
        canvas.translate(150f, 200f)
        //线帽测试：
        mRedPaint.strokeCap = Paint.Cap.BUTT//无头(默认)
        canvas.drawLine(0f, 0f, 0f, 200f, mRedPaint)
        canvas.translate(150f, 0f)
        mRedPaint.strokeCap = Paint.Cap.ROUND//圆头
        canvas.drawLine(0f, 0f, 0f, 200f, mRedPaint)
        canvas.translate(150f, 0f)
        mRedPaint.strokeCap = Paint.Cap.SQUARE//方头
        canvas.drawLine(0f, 0f, 0f, 200f, mRedPaint)
        canvas.restore()
    }

    /**
     * 四、线交角测试：Paint.Join.：[#BEVEL|ROUND|MITER]
     *
     *  注意：只有路径绘制的线才有交角效果
     */
    // 角型测试：Paint.Join.BEVEL、Paint.Join.ROUND、Paint.Join.MITER
    private fun testOfJoin(canvas: Canvas) {
        mRedPaint.style = Paint.Style.STROKE
        mRedPaint.strokeWidth = 50f
        val path = Path()
        path.moveTo(30f, 0f)
        path.lineTo(0f, 100f)
        path.lineTo(100f, 100f)

        canvas.save()
        canvas.translate(400f, 100f)
        mRedPaint.strokeJoin = Paint.Join.BEVEL//直线(默认)
        canvas.drawPath(path, mRedPaint)

        canvas.translate(200f, 0f)
        mRedPaint.strokeJoin = Paint.Join.ROUND//圆角
        canvas.drawPath(path, mRedPaint)

        canvas.translate(200f, 0f)
        mRedPaint.strokeJoin = Paint.Join.MITER//锐角
        canvas.drawPath(path, mRedPaint)
        canvas.restore()
    }

    /**
     * 五、Paint的路径效果
     */

    // 1.虚线：DashPathEffect(new float[]{a, b, a1, b1...}, offSet)
    // 虚线测试
    private fun dashEffect(canvas: Canvas) {
        mRedPaint.strokeCap = Paint.Cap.BUTT
        //显示100，隐藏50,显示50，隐藏50,的循环
        mRedPaint.pathEffect = DashPathEffect(floatArrayOf(100f, 50f, 50f, 50f), 0f)
        val path = Path()
        path.moveTo(100f, 350f)
        path.lineTo(1000f, 350f)
        canvas.drawPath(path, mRedPaint)
        //显示100，隐藏50,显示60，隐藏50,的循环,偏移：mDashOffSet
        mRedPaint.pathEffect = DashPathEffect(floatArrayOf(100f, 50f, 50f, 50f), 10f)
        val pathOffset50 = Path()
        pathOffset50.moveTo(100f, 450f)
        pathOffset50.lineTo(1000f, 450f)
        canvas.drawPath(pathOffset50, mRedPaint)
    }

    // 2.折角弧：CornerPathEffect(corner)
    // 圆角折线
    private fun cornerEffect(canvas: Canvas) {
        mRedPaint.pathEffect = CornerPathEffect(10f)
        mRedPaint.style = Paint.Style.STROKE
        mRedPaint.strokeWidth = 40f
        val path = Path()
        path.moveTo(550f, 550f)
        path.lineTo(900f, 300f)
        path.lineTo(1000f, 550f)
        canvas.drawPath(path, mRedPaint)
        //蓝色辅助线
        val tempPaint = Paint()
        tempPaint.style = Paint.Style.STROKE
        tempPaint.color = Color.BLUE
        tempPaint.strokeWidth = 2f
        tempPaint.pathEffect = DashPathEffect(floatArrayOf(20f, 20f), 0f)
        val helpPath = Path()
        helpPath.moveTo(550f, 550f)
        helpPath.lineTo(900f, 300f)
        helpPath.lineTo(1000f, 550f)
        canvas.drawPath(helpPath, tempPaint)
    }

    // 3.离散路径：DiscretePathEffect(小段长，偏移量)
    // 离散路径
    private fun discreteEffect(canvas: Canvas) {
        mRedPaint.style = Paint.Style.STROKE
        canvas.save()//保存画布状态
        canvas.translate(0f, 350f)
        //第一个参数：将原来的路径切成多长的线段,越小，所切成的小线段越多
        //第二参数：被切成的每个小线段的可偏移距离。越大，每个线段的可偏移距离就越大。
        val path = Path()
        // 定义路径的起点
        path.moveTo(100f, 0f)
        path.lineTo(600f, -100f)
        path.lineTo(1000f, 0f)

        mRedPaint.pathEffect = DiscretePathEffect(2f, 5f)
        mRedPaint.strokeWidth = 2f
        canvas.drawPath(path, mRedPaint)
        canvas.translate(0f, 100f)
        mRedPaint.pathEffect = DiscretePathEffect(20f, 5f)
        canvas.drawPath(path, mRedPaint)
        canvas.restore()//重新储存画布状态
    }

    //4.路径点样：PathDashPathEffect(路径,间距，偏移，样式)
    // 路径点样路径样式
    private fun PathDashEffect(canvas: Canvas) {
        canvas.save()
        canvas.translate(0f, 300f)
        val path = Path()
        // 定义路径的起点
        path.moveTo(100f, 80f)
        path.lineTo(600f, -100f)
        path.lineTo(1000f, 80f)
        //变形过渡
        mRedPaint.pathEffect = PathDashPathEffect(
            CommonPath.nStarPath(5, 16f, 8f), 40f, 10f, PathDashPathEffect.Style.ROTATE
        )
        canvas.drawPath(path, mRedPaint)
        canvas.restore()
        //旋转过渡
        canvas.save()
        canvas.translate(0f, 500f)
        mRedPaint.pathEffect = PathDashPathEffect(
            CommonPath.nStarPath(5, 16f, 8f), 40f, 10f, PathDashPathEffect.Style.MORPH
        )
        canvas.drawPath(path, mRedPaint)
        canvas.restore()
        //移动过渡
        canvas.save()
        canvas.translate(0f, 800f)
        mRedPaint.pathEffect = PathDashPathEffect(
            CommonPath.nStarPath(5, 16f, 8f), 40f, 10f, PathDashPathEffect.Style.TRANSLATE
        )
        canvas.drawPath(path, mRedPaint)
        canvas.restore()
    }

    // 5.叠加特效：PathDashPathEffect(e1,e2...)
    // 叠加样式
    private fun composeEffect(canvas: Canvas) {
        mRedPaint.style = Paint.Style.STROKE
        mRedPaint.strokeWidth = 40f
        canvas.save()
        canvas.translate(0f, 300f)
        val path = Path()
        // 定义路径的起点
        path.moveTo(100f, 80f)
        path.lineTo(600f, -100f)
        path.lineTo(1000f, 80f)
        val effect1 = PathDashPathEffect(
            CommonPath.nStarPath(5, 16f, 8f), 40f, 10f, PathDashPathEffect.Style.ROTATE
        )
        val effect2 = DiscretePathEffect(20f, 5f)
        mRedPaint.pathEffect = ComposePathEffect(effect1, effect2)//离散效果+样点效果
        canvas.drawPath(path, mRedPaint)
        canvas.restore()
    }

    // 6.路径叠加
    // 路径叠加
    private fun sumEffect(canvas: Canvas) {
        canvas.save()
        canvas.translate(0f, 300f)
        val path = Path()
        // 定义路径的起点
        path.moveTo(100f, 80f)
        path.lineTo(600f, -100f)
        path.lineTo(1000f, 80f)
        val effect1 = PathDashPathEffect(
            CommonPath.nStarPath(5, 16f, 8f), 40f, 10f, PathDashPathEffect.Style.ROTATE
        )
        val effect2 = DiscretePathEffect(20f, 5f)
        mRedPaint.setPathEffect(SumPathEffect(effect1, effect2))//离散效果+样点效果
        canvas.drawPath(path, mRedPaint)
        canvas.restore()
    }

    /**
     * 六.着色器：Shader
     */
    /*
    1.线性渐变：
    1).new LinearGradient(渐变起点x，y,渐变终点x,y,渐变色1，渐变色2，渐变模式)
     */
    private fun test1(canvas: Canvas) {
        val colorStart = Color.parseColor("#84F125")
        val colorEnd = Color.parseColor("#5825F1")
        canvas.save()
        canvas.translate(500f, 300f)
        mRedPaint.style = Paint.Style.FILL
        mRedPaint.shader = LinearGradient(
            -200f, 0f, 200f, 0f,
            colorStart, colorEnd,
            Shader.TileMode.MIRROR

        )
        canvas.drawRect(-400f, -200f, 400f, -100f, mRedPaint)

        canvas.translate(0f, 150f)
        mRedPaint.shader = LinearGradient(
            -100f, 0f, 100f, 0f,
            colorStart, colorEnd,
            Shader.TileMode.CLAMP
        )
        canvas.drawRect(-400f, -200f, 400f, -100f, mRedPaint)

        canvas.translate(0f, 150f)
        mRedPaint.shader = LinearGradient(
            -100f, 0f, 100f, 0f,
            colorStart, colorEnd,
            Shader.TileMode.REPEAT
        )
        canvas.drawRect(-400f, -200f, 400f, -100f, mRedPaint)
    }

    // 2).多色多点渐变：LinearGradient(渐变起点x，y,渐变终点x,y,颜色数组，位置百分点数组0~1,渐变模式)
    private fun test2(canvas: Canvas) {
        val colors = intArrayOf(
            Color.parseColor("#F60C0C"), //红
            Color.parseColor("#F3B913"), //橙
            Color.parseColor("#E7F716"), //黄
            Color.parseColor("#3DF30B"), //绿
            Color.parseColor("#0DF6EF"), //青
            Color.parseColor("#0829FB"), //蓝
            Color.parseColor("#B709F4")
        )//紫
        val pos = floatArrayOf(1f / 7, 2f / 7, 3f / 7, 4f / 7, 5f / 7, 6f / 7, 1f)

        canvas.translate(500f, 350f)
        mRedPaint.shader = LinearGradient(
            -300f, 0f, 300f, 0f,
            colors, pos,
            Shader.TileMode.CLAMP

        )
        canvas.drawRect(-400f, -200f, 400f, -100f, mRedPaint)
    }

    /*
    2.径向渐变：RadialGradient
    1).两色渐变：RadialGradient(渐变中心，渐变半径，颜色1，颜色2，渐变模式)
     */
    private fun test3(canvas: Canvas) {
        canvas.translate(300f, 300f)
        val colorStart = Color.parseColor("#84F125")
        val colorEnd = Color.parseColor("#5825F1")
        mRedPaint.style = Paint.Style.FILL
        mRedPaint.shader = RadialGradient(
            0f, 0f, 50f,
            colorStart, colorEnd,
            Shader.TileMode.MIRROR

        )

        canvas.drawCircle(0f, 0f, 150f, mRedPaint)

        canvas.translate(350f, 0f)
        mRedPaint.shader = RadialGradient(
            0f, 0f, 50f,
            colorStart, colorEnd,
            Shader.TileMode.CLAMP

        )
        canvas.drawCircle(0f, 0f, 150f, mRedPaint)


        canvas.translate(350f, 0f)
        mRedPaint.shader = RadialGradient(
            0f, 0f, 50f,
            colorStart, colorEnd,
            Shader.TileMode.REPEAT

        )
        canvas.drawCircle(0f, 0f, 150f, mRedPaint)
    }

    // 2).多色多点径向渐变： RadialGradient(渐变中心，渐变半径，渐变模式,颜色数组，位置百分点数组0~1,渐变模式)
    private fun test4(canvas: Canvas) {
        canvas.translate(500f, 500f)
        val colors = intArrayOf(
            Color.parseColor("#F60C0C"), //红
            Color.parseColor("#F3B913"), //橙
            Color.parseColor("#E7F716"), //黄
            Color.parseColor("#3DF30B"), //绿
            Color.parseColor("#0DF6EF"), //青
            Color.parseColor("#0829FB"), //蓝
            Color.parseColor("#B709F4")
        )//紫
        val pos = floatArrayOf(1f / 7, 2f / 7, 3f / 7, 4f / 7, 5f / 7, 6f / 7, 1f)
        mRedPaint.style = Paint.Style.FILL
        mRedPaint.shader = RadialGradient(
            0f, 0f, 200f,
            colors, pos,
            Shader.TileMode.CLAMP
        )
        canvas.drawCircle(0f, 0f, 250f, mRedPaint)
    }

    /*
    3.扫描渐变：SweepGradient
    这个要比上面的简单一点，没有渐变的模式
    双色扫描渐变：SweepGradient(中心点x,y,颜色1，颜色2)
    多色扫描渐变：SweepGradient(中心点x,y,颜色数组，位置百分点数组0~1)
     */
    private fun test5(canvas: Canvas) {
        canvas.translate(500f, 500f)
        val colorStart = Color.parseColor("#84F125")
        val colorEnd = Color.parseColor("#5825F1")
        mRedPaint.style = Paint.Style.FILL
        mRedPaint.shader = SweepGradient(0f, 0f, colorStart, colorEnd)
        canvas.drawCircle(0f, 0f, 150f, mRedPaint)

        val colors = intArrayOf(
            Color.parseColor("#F60C0C"), //红
            Color.parseColor("#F3B913"), //橙
            Color.parseColor("#E7F716"), //黄
            Color.parseColor("#3DF30B"), //绿
            Color.parseColor("#0DF6EF"), //青
            Color.parseColor("#0829FB"), //蓝
            Color.parseColor("#B709F4")
        )//紫
        val pos = floatArrayOf(1f / 7, 2f / 7, 3f / 7, 4f / 7, 5f / 7, 6f / 7, 1f)
        mRedPaint.shader = SweepGradient(0f, 0f, colors, pos)
        canvas.drawCircle(0f, 0f, 150f, mRedPaint)
    }

    /*
    4.图片着色器：BitmapShader(图片，着色模式x，着色模式y)
    用图片的所有像素点作为画笔的颜色

    1).文字的图片底色：
     */
    private fun test6(canvas: Canvas) {
        //加载图片，生成图片着色器
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.test)
        val bs = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mRedPaint.shader = bs
        mRedPaint.textSize = 150f
        mRedPaint.strokeWidth = 10f
        mRedPaint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawText("HELLO WORLD!", 50f, 500f, mRedPaint)
    }

    // 2)路径+图片着色器实现裁剪图片：
    private fun test7(canvas: Canvas) {
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.test)
        val bs = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mRedPaint.shader = bs

        mRedPaint.style = Paint.Style.FILL
        val path = CommonPath.nStarPath(5, 500f, 250f)
        canvas.drawPath(path, mRedPaint)
    }

    /**
     * 七、颜色过滤器:(具体原理是颜色运算)
     *
     * ColorFilter只有三个子类
     */
    //1.LightingColorFilter(颜色1，颜色2)：
    private fun test8(canvas: Canvas) {
        val mainBitmap = BitmapFactory.decodeResource(resources, R.mipmap.test)
        mRedPaint.style = Paint.Style.FILL
        mRedPaint.colorFilter = LightingColorFilter(
            Color.parseColor("#FF0000"), //红
            Color.parseColor("#0000ff")//蓝
        )
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)

        canvas.translate(0f, 500f)
        mRedPaint.colorFilter = LightingColorFilter(
            Color.parseColor("#FF0000"), //红
            Color.parseColor("#00ff00")//绿
        )
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)

        canvas.translate(0f, 500f)
        mRedPaint.colorFilter = LightingColorFilter(
            Color.parseColor("#FF0000"), //红
            Color.parseColor("#000000")//黑
        )
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)
    }

    //2.PorterDuffColorFilter(颜色，模式--PorterDuff.Mode)：
    private fun test9(canvas: Canvas) {
        val mainBitmap = BitmapFactory.decodeResource(resources, R.mipmap.test)
        mRedPaint.style = Paint.Style.FILL

        mRedPaint.colorFilter = PorterDuffColorFilter(
            Color.parseColor("#0000ff"), PorterDuff.Mode.DARKEN
        )
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)

        canvas.translate(0f, 500f)
        mRedPaint.colorFilter = PorterDuffColorFilter(
            Color.parseColor("#0000ff"), PorterDuff.Mode.LIGHTEN
        )
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)

        canvas.translate(0f, 500f)
        mRedPaint.colorFilter = PorterDuffColorFilter(
            Color.parseColor("#0000ff"), PorterDuff.Mode.SCREEN
        )
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)

        canvas.translate(0f, 500f)
        mRedPaint.colorFilter = PorterDuffColorFilter(
            Color.parseColor("#0000ff"), PorterDuff.Mode.OVERLAY
        )
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)
    }

    // 3.ColorMatrixColorFilter(颜色变换矩阵或25个float数)
    private fun test10(canvas: Canvas) {
        val mainBitmap = BitmapFactory.decodeResource(resources, R.mipmap.test)
        mRedPaint.style = Paint.Style.FILL

        //关闭RGB颜色通道(变为黑色)，后偏移红色255
        val matrix = floatArrayOf(-1f, 0f, 0f, 0f, 255f, 0f, -1f, 0f, 0f, 0f, 0f, 0f, -1f, 0f, 0f, 0f, 0f, 0f, 1f, 0f)
        val colorMatrix = ColorMatrix(matrix)
        mRedPaint.colorFilter = ColorMatrixColorFilter(colorMatrix)
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)


        canvas.translate(0f, 500f)
        //关闭RGB颜色通道(变为黑色)，后偏移蓝色255
        val matrix2 = floatArrayOf(-1f, 0f, 0f, 0f, 0f, 0f, -1f, 0f, 0f, 0f, 0f, 0f, -1f, 0f, 255f, 0f, 0f, 0f, 1f, 0f)
        val colorMatrix2 = ColorMatrix(matrix2)
        mRedPaint.colorFilter = ColorMatrixColorFilter(colorMatrix2)
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)

        canvas.translate(0f, 500f)
        //关闭RGB颜色通道(变为黑色)，后偏移三色255
        val matrix3 =
            floatArrayOf(-1f, 0f, 0f, 0f, 255f, 0f, -1f, 0f, 0f, 255f, 0f, 0f, -1f, 0f, 255f, 0f, 0f, 0f, 1f, 0f)
        val colorMatrix3 = ColorMatrix(matrix3)
        mRedPaint.colorFilter = ColorMatrixColorFilter(colorMatrix3)
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)

        canvas.translate(0f, 500f)

        //只要把RGB三通道的色彩信息设置成一样:即：R＝G＝B,
        // 为了保证图像亮度不变，同一个通道中的R+G+B=1
        val matrix4 = floatArrayOf(
            0.3086f,
            0.6094f,
            0.0820f,
            0f,
            0f,
            0.3086f,
            0.6094f,
            0.0820f,
            0f,
            0f,
            0.3086f,
            0.6094f,
            0.0820f,
            0f,
            0f,
            0f,
            0f,
            0f,
            1f,
            0f
        )
        val colorMatrix4 = ColorMatrix(matrix4)
        mRedPaint.colorFilter = ColorMatrixColorFilter(colorMatrix4)
        canvas.drawBitmap(mainBitmap, 50f, 0f, mRedPaint)
    }


    /**
     * 八、文字相关
     *
     * 字体.setTypeface(Typeface.SANS_SERIF);
     * 对齐方式.setTextAlign(Paint.Align.LEFT);
     * 字体大小.setTextSize(100);
     */

    /*
     对齐：Paint.Align.[#LEFT|RIGHT|CENTER]
     内置字体:Typeface.[#DEFAULT|DEFAULT_BOLD|SANS_SERIF|SERIF|MONOSPACE]
     */
    private fun test11(canvas: Canvas) {
        canvas.save()
        canvas.translate(550f, 600f)
        mRedPaint.typeface = Typeface.SANS_SERIF
        mRedPaint.textAlign = Paint.Align.LEFT
        mRedPaint.textSize = 100f
        canvas.drawText("SANS_SERIF", 0f, 0f, mRedPaint)
        val tempPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        tempPaint.strokeWidth = 4f
        tempPaint.color = Color.RED
        tempPaint.style = Paint.Style.STROKE
        canvas.drawRect(0f, -100f, 600f, 0f, tempPaint)

        canvas.translate(0f, 150f)
        mRedPaint.textAlign = Paint.Align.RIGHT
        mRedPaint.typeface = Typeface.SERIF
        canvas.drawText("SERIF", 0f, 0f, mRedPaint)
        canvas.drawRect(0f, -100f, 600f, 0f, tempPaint)

        canvas.translate(0f, 150f)
        mRedPaint.typeface = Typeface.MONOSPACE
        mRedPaint.textAlign = Paint.Align.CENTER
        canvas.drawText("MONOSPACE", 0f, 0f, mRedPaint)
        canvas.drawRect(0f, -100f, 600f, 0f, tempPaint)

        canvas.restore()
    }

    // 2.创建字体：外部字体放在assets目录下
    private fun test12(canvas: Canvas) {
        mRedPaint.textSize = 50f
        canvas.save()
        canvas.translate(50f, 1000f)
        mRedPaint.typeface = Typeface.MONOSPACE
        canvas.drawText("MONOSPACE", 0f, 0f, mRedPaint)
        //粗体
        canvas.translate(0f, 100f)
        val typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
        mRedPaint.typeface = typeface
        canvas.drawText("MONOSPACE+BOLD", 0f, 0f, mRedPaint)
        //斜体
        canvas.translate(0f, 100f)
        val typeface2 = Typeface.create(Typeface.MONOSPACE, Typeface.ITALIC)
        mRedPaint.typeface = typeface2
        canvas.drawText("MONOSPACE+ITALIC", 0f, 0f, mRedPaint)
        //粗斜体
        canvas.translate(0f, 100f)
        val typeface3 = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD_ITALIC)
        mRedPaint.typeface = typeface3
        canvas.drawText("MONOSPACE+BOLD_ITALIC", 0f, 0f, mRedPaint)
        //使用外部字体
        canvas.translate(0f, 100f)
        val myFont = Typeface.createFromAsset(context.assets, "OpenDyslexic3-Regular.ttf")
        mRedPaint.typeface = myFont
        canvas.drawText("Hello World!", 0f, 0f, mRedPaint)
        canvas.restore()
    }

    /*
    3.文字的测量：FontMetrics
    1).字体测量类：FontMetrics
    2).SERIF字体测试：
     */
    private fun test13(canvas: Canvas) {
        canvas.save()
        canvas.translate(100f, 500f)
        mRedPaint.textSize = 200f
        mRedPaint.typeface = Typeface.SERIF
        canvas.drawText("Hello World", 0f, 0f, mRedPaint)
        //获取字体尺寸
        val fm = mRedPaint.fontMetrics

        Log.e(TAG, "top: " + fm.top)
        Log.e(TAG, "ascent: " + fm.ascent)
        Log.e(TAG, "leading: " + fm.leading)
        Log.e(TAG, "descent: " + fm.descent)
        Log.e(TAG, "bottom: " + fm.bottom)

        val tempPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        tempPaint.strokeWidth = 1f
        tempPaint.color = Color.RED
        tempPaint.style = Paint.Style.STROKE

        canvas.drawLine(0f, fm.top, 1100f, fm.top, tempPaint)

        tempPaint.color = Color.MAGENTA
        canvas.drawLine(0f, fm.ascent, 1100f, fm.ascent, tempPaint)

        tempPaint.color = Color.parseColor("#4C17F9")
        canvas.drawLine(0f, fm.leading, 1100f, fm.leading, tempPaint)

        tempPaint.color = Color.GREEN
        canvas.drawLine(0f, fm.descent, 1100f, fm.descent, tempPaint)

        tempPaint.color = Color.parseColor("#E74EDD")
        canvas.drawLine(0f, fm.bottom, 1100f, fm.bottom, tempPaint)
    }

    // 3).获取文字矩形区
    private fun test14(canvas: Canvas) {
        test13(canvas)
        val text = "Hello World"
        val textRect = Rect()
        mRedPaint.getTextBounds(text, 0, text.length, textRect)
        Log.e(TAG, textRect.toShortString())// [7,-152][886,49]
        //绘制矩形
        val tempPaint = Paint()
        tempPaint.color = Color.parseColor("#66F4F628")
        tempPaint.style = Paint.Style.FILL
        canvas.drawRect(textRect, tempPaint)
    }

    // 4).文字的变形操作
    private fun test15(canvas: Canvas) {
        mRedPaint.textScaleX = 0.7f //水平伸缩
        mRedPaint.isStrikeThruText = true //删除线
        mRedPaint.isUnderlineText = true //下划线
        mRedPaint.textSkewX = -0.5f //倾斜
        test13(canvas)
    }
}
