package com.stefan.ccfbturrets;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Array<Sprite> turOne;
    Sprite arspTop1[] = new Sprite[100], arspTop2[] = new Sprite[100], arspTop3[] = new Sprite[100], arspTop4[] = new Sprite[100];
    Sprite spTopSel[] = new Sprite[100];
    int a = 0, b = 0, c = 0, d = 0, nNum = 1, i = 0;
    private Vector3 vtouchPos;

    @Override
    public void create() {
        batch = new SpriteBatch();
        //turOne = new Array<Sprite>();
        /*while(a<100) {
			turOne.add(new Turrets(new Sprite(new Texture("can_top.jpg"))));
			arspTop1[a] = new Turrets(new Sprite(new Texture("can_top.jpg")));
			arspTop1[a].setSize(50, 50);
			a++;
		}
		while(b<100) {
			arspTop2[b] =new Turrets(new Sprite(new Texture("can_topblack.png")));
			arspTop2[b].setSize(50, 50);
			b++;
		}
		while(c<100) {
			arspTop3[c] = new Turrets(new Sprite(new Texture("can_topblue.png")));
			arspTop3[c].setSize(50, 50);
			c++;
		}
		while(d<100) {
			arspTop4[d] = new Turrets(new Sprite(new Texture("can_topred.png")));
			arspTop4[d].setSize(50, 50);
			d++;
		}
		a=0;
		b=0;
		c=0;
		d=0;*/
        while (i < 100) { //a much shorter version of the original code above thanks to Don Vo
            arspTop1[i] = new Turrets(new Sprite(new Texture("can_top.jpg")));
            arspTop1[i].setSize(50, 50);
            arspTop2[i] =new Turrets(new Sprite(new Texture("can_topblack.png")));
            arspTop2[i].setSize(50, 50);
            arspTop3[i] = new Turrets(new Sprite(new Texture("can_topblue.png")));
            arspTop3[i].setSize(50, 50);
            arspTop4[i] = new Turrets(new Sprite(new Texture("can_topred.png")));
            arspTop4[i].setSize(50, 50);
            i++;
        }
        spTopSel[0]= new Sprite(new Texture("can_top.jpg"));
        spTopSel[0].setSize(1, 1);
        spTopSel[0].setPosition(Gdx.graphics.getWidth() - 100,
                Gdx.graphics.getHeight() - 100);
        vtouchPos = new Vector3();
        i = 0;
    }

    @Override
    public void render() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {//once again a shorter code than before
            vtouchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (nNum == 1) {
                spTopSel[i]=arspTop1[a];
                a++;
                nNum++;
            } else if (nNum == 2) {
                spTopSel[i]=arspTop2[b];
                b++;
                nNum++;
            } else if (nNum == 3) {
                spTopSel[i]=arspTop3[c];
                c++;
                nNum++;
            } else if (nNum == 4) {
                spTopSel[i]=arspTop4[d];
                d++;
                nNum = 1;
            }
            spTopSel[i].setPosition(vtouchPos.x - arspTop4[d].getHeight() / 2, vtouchPos.y - arspTop4[d].getWidth() / 2);
            //i++;//the code stops working once this line is in it but works (incorrectly) when it is removed
        }
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        spTopSel[i].draw(batch);
        batch.end();
    }
}
