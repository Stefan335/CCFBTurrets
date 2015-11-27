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

public class MyGdxGame extends Game implements InputProcessor {
    SpriteBatch batch;
    Array<Sprite> turOne;

    Sprite arspTop1[] = new Sprite[100], arspTop2[] = new Sprite[100], arspTop3[] = new Sprite[100], arspTop4[] = new Sprite[100];
    int a = 0, b = 0, c = 0, d = 0, nNum = 1;
    //int arnTop1x[] = new int[10],  arnTop2x[] = new int[10],arnTop3x[] = new int[10], arnTop4x[] = new int[10];
    //int arnTop1y[] = new int[10],  arnTop2y[] = new int[10],arnTop3y[] = new int[10], arnTop4y[] = new int[10];
    private Vector3 vtouchPos;

    @Override
    public void create() {
        batch = new SpriteBatch();
        turOne = new Array<Sprite>();
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
        int i = 0;
        while (i < 100) {
            arspTop1[i] = new Turrets(new Sprite(new Texture("can_top.jpg")));
            arspTop1[i].setSize(50, 50);
            arspTop2[i] =new Turrets(new Sprite(new Texture("can_topblack.png")));
            arspTop2[i].setSize(50, 50);
            arspTop3[i] = new Turrets(new Sprite(new Texture("can_topblue.png")));
            arspTop3[i].setSize(50, 50);
            arspTop4[i] = new Turrets(new Sprite(new Texture("can_topred.png")));
            arspTop4[i].setSize(50, 50);
        }
        vtouchPos = new Vector3();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            vtouchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (nNum == 1) {
                turOne.indexOf(turOne.get(a), true);
                arspTop1[a].setPosition(vtouchPos.x - arspTop1[a].getHeight() / 2, vtouchPos.y - arspTop1[a].getWidth() / 2);
                arspTop1[a].draw(batch);
                a++;
                nNum++;
            } else if (nNum == 2) {
                arspTop2[b].setPosition(vtouchPos.x - arspTop2[b].getHeight() / 2, vtouchPos.y - arspTop2[b].getWidth() / 2);
                arspTop2[b].draw(batch);
                b++;
                nNum++;
            } else if (nNum == 3) {
                arspTop3[c].setPosition(vtouchPos.x - arspTop3[c].getHeight() / 2, vtouchPos.y - arspTop3[c].getWidth() / 2);
                arspTop3[c].draw(batch);
                c++;
                nNum++;
            } else if (nNum == 4) {
                arspTop4[d].setPosition(vtouchPos.x - arspTop4[d].getHeight() / 2, vtouchPos.y - arspTop4[d].getWidth() / 2);
                arspTop4[d].draw(batch);
                d++;
                nNum = 1;
            }
        }
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
