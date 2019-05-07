/*
 * Copyright (C) 2019 csc190
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package EvilCraft;

import BridgePattern.ICanvasDevice;
import BridgePattern.IGameEngine;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the Palette of buttons for creating units
 *
 * @author csc190
 */
public class ButtonController implements IGameEngine {

    //---- DATA MEMBERS ------------------
    protected ArrayList<ShopButton> arrButtons;
    protected Team myteam;
    protected ICanvasDevice canvas;
    //---- OPERATIONS --------------------

    /**
     * Create 3 buttons and set up the team and canvas for future use
     *
     * @param team
     * @param canvas
     */
    public ButtonController(Team team, ICanvasDevice canvas) {
        this.myteam = team;
        this.canvas = canvas;
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * For each button, update() them and drawThem. Draw the text for remaining
     * cash as well
     */
    @Override
    public void onTick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRightClick(ICanvasDevice canvas, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onLeftClick(ICanvasDevice canvas, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRegionSelected(ICanvasDevice canvas, int x1, int y1, int x2, int y2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onMouseMoved(ICanvasDevice canvas, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected Point genRandomLoc() {
        Random rand = new Random();
        int x = this.myteam.getBase().getX();
        int y = this.myteam.getBase().getY();
        if (rand.nextBoolean()) {
            x = x + rand.nextInt(600);
            y = y + rand.nextInt(600);
        } else {
            x = x - rand.nextInt(600);
            y = y - rand.nextInt(600);
        }
        return new Point(x, y);
    }

    /**
     * return true if there's money for it
     */
    public boolean spawnTank() {
        if (!this.myteam.PurchaseSprite("TANK")) {
            return false;
        }
        Point pt = this.genRandomLoc();
        Tank tank = new Tank(this.myteam, pt.x, pt.y, 50, 50);
        GameEngine.getInstance().addSprite(tank);
        this.myteam.addSprite(tank);
        return true;
    }

    /**
     * return true if there's money for it
     */
    public boolean spawnAircraft() {
        if (!this.myteam.PurchaseSprite("PLANE")) {
            return false;
        }
        Point pt = this.genRandomLoc();
        Airplane plane = new Airplane(this.myteam, pt.x, pt.y, 50, 50);
        GameEngine.getInstance().addSprite(plane);
        this.myteam.addSprite(plane);
        return true;
    }

    /**
     * return true if there's money for it
     */
    public boolean spawnInfantry() {
        if (!this.myteam.PurchaseSprite("INFANTRY")) {
            return false;
        }
        Point pt = this.genRandomLoc();
        Infantry soldier = new Infantry(this.myteam, pt.x, pt.y, 25, 25);
        GameEngine.getInstance().addSprite(soldier);
        this.myteam.addSprite(soldier);
        return true;
    }

}