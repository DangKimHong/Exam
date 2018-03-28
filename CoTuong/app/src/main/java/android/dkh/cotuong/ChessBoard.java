package android.dkh.cotuong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 28/03/2018.
 */

public class ChessBoard {
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private int[][] board;
    private int player;

    private Context context;

    private int bitmapWidth;
    private int bitmapHeight;
    private int colQty;
    private int rowQty;
    private List<Line> arrayLines;

    public ChessBoard(Context context, int bitmapWidth, int bitmapHeight, int colQty, int rowQty) {
        this.context = context;
        this.bitmapWidth = bitmapWidth;
        this.bitmapHeight = bitmapHeight;
        this.colQty = colQty;
        this.rowQty = rowQty;
    }

    public void init(){
        bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        int strokeWidth = 2;
        paint.setStrokeWidth(strokeWidth);
        board = new int[rowQty][colQty];
        player = 0;
        arrayLines = new ArrayList<>();

        int cellWitdh = bitmapWidth / colQty;
        int cellHeight = bitmapHeight / rowQty;
        int halfHeighttop = ((rowQty-1)/2*cellWitdh);
        int halfHeightBottom =((rowQty+1)/2 *cellHeight);
        for (int i = 0; i <= colQty; i++) {
            arrayLines.add(new Line(i * cellWitdh, 0, i * cellWitdh, halfHeighttop));
       }

        for (int i = 0; i <= rowQty; i++) {
            arrayLines.add(new Line(0, i * cellHeight, bitmapWidth, i * cellHeight));
        }

        for (int j = 0; j <= colQty; j++) {
            arrayLines.add(new Line((j * cellWitdh), halfHeightBottom + 0, j * cellWitdh, halfHeightBottom + bitmapHeight));
        }

        //vẽ đường chéo trên
        arrayLines.add(new Line(3*cellWitdh, 0, 5*cellWitdh, 2*cellHeight));
        arrayLines.add(new Line(5*cellWitdh, 0, 3*cellWitdh, 2*cellHeight));

        //vẽ đường chéo dưới
        arrayLines.add(new Line(3*cellWitdh, bitmapHeight, 5*cellHeight, 7*cellHeight));
        arrayLines.add(new Line(5*cellWitdh, bitmapHeight, 3*cellWitdh, 7*cellHeight));

        for (int i = 0; i < colQty; i++) {
            for (int j = 0; j < rowQty; j++) {
                board[i][i] = -1;
            }
        }
    }

    public Bitmap drawBoard() {
        for (Line line : arrayLines) {
            canvas.drawLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY(), paint);
        }

        return this.bitmap;
    }


}
