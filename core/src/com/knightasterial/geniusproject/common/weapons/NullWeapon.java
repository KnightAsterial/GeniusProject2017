package com.knightasterial.geniusproject.common.weapons;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.knightasterial.geniusproject.common.bullets.BasicBullet;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;
import com.knightasterial.geniusproject.common.util.GameConstants;

public class NullWeapon extends AbstractGun{
	
	public NullWeapon(){
		//stats of gun declared
		name = GameConstants.NULL_WEAPON_ID;
		description = "Empty placeholder";
		damage = 0;
		fireRate = 0;
		reloadTime = 0;
		bulletsPerFire = 0;
		bulletSpeed = 0;
		bulletSpread = 0;
		maxAmmo = 0;
		currentAmmo = maxAmmo;
		nanoTimeOfFire = -1;
		nanoTimeOfReload = -1;
	}
	
	@Override
	public void fire(PlayerEntity player, List<BasicBullet> bulletList, OrthographicCamera inGameCam) {
		return;
	}

	@Override
	public void reload() {
		return;
	}
	
}
