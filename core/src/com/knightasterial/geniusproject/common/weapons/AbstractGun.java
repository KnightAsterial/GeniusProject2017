package com.knightasterial.geniusproject.common.weapons;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.TimeUtils;
import com.knightasterial.geniusproject.common.bullets.BasicBullet;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;

public abstract class AbstractGun {
	String name;
	String description;
	
	float damage;
	
	/**
	 * fire rate in seconds
	 */
	
	float fireRate;
	
	/**
	 * reload time in seconds
	 */
	float reloadTime;
	
	int bulletsPerFire;
	
	float bulletSpeed;
	
	float bulletSpread;
	
	int currentAmmo;
	
	int maxAmmo;
	
	long nanoTimeOfFire;
	
	long nanoTimeOfReload;
	

	
	public abstract void fire(PlayerEntity player, List<BasicBullet> bulletList, OrthographicCamera inGameCam);
	public abstract void reload();
	
	
	

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public float getFireRate() {
		return fireRate;
	}

	public void setFireRate(float fireRate) {
		this.fireRate = fireRate;
	}

	public float getReloadTime() {
		return reloadTime;
	}
	public void setReloadTime(float reloadTime) {
		this.reloadTime = reloadTime;
	}
	public int getBulletsPerFire() {
		return bulletsPerFire;
	}

	public void setBulletsPerFire(int bulletsPerFire) {
		this.bulletsPerFire = bulletsPerFire;
	}

	public float getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(float bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

	public float getBulletSpread() {
		return bulletSpread;
	}

	public void setBulletSpread(float bulletSpread) {
		this.bulletSpread = bulletSpread;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getCurrentAmmo() {
		return currentAmmo;
	}
	public void setCurrentAmmo(int currentAmmo) {
		this.currentAmmo = currentAmmo;
	}
	public int getMaxAmmo() {
		return maxAmmo;
	}
	public void setMaxAmmo(int maxAmmo) {
		this.maxAmmo = maxAmmo;
	}
	public long getNanoTimeOfFire() {
		return nanoTimeOfFire;
	}
	public void setNanoTimeOfFire(long nanoTimeOfFire) {
		this.nanoTimeOfFire = nanoTimeOfFire;
	}
	public long getNanoTimeOfReload() {
		return nanoTimeOfReload;
	}
	public void setNanoTimeOfReload(long nanoTimeOfReload) {
		this.nanoTimeOfReload = nanoTimeOfReload;
	}
	
	public String getDisplayText(){
		if ((TimeUtils.nanoTime()-nanoTimeOfReload) < (reloadTime*1000000000)){
			return "Reloading";
		}
		else if (nanoTimeOfReload < 0){
			return currentAmmo + "";
		}
		else{
			return currentAmmo + "";
		}
	}
	
	
}
