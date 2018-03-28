package android.dkh.cotuong;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    ChessBoard chessBoard;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.imgView);
        chessBoard = new ChessBoard(this, 720, 810, 8, 9);
        chessBoard.init();

        bitmap = chessBoard.drawBoard();

        imgView.setImageBitmap(bitmap);
    }
}
