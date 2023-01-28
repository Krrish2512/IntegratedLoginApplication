package com.example.loginapp

import android.Manifest
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener


class Flashlight : AppCompatActivity() {
    var imageButton: ImageButton? = null
    var state = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashlight)
        imageButton = findViewById(R.id.torchbtn)
        Dexter.withContext(this).withPermission(Manifest.permission.CAMERA)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(permissionGrantedResponse: PermissionGrantedResponse) {
                    runFlashlight()
                }

                override fun onPermissionDenied(permissionDeniedResponse: PermissionDeniedResponse) {
                    Toast.makeText(
                        this@Flashlight,
                        "Camera permission required.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissionRequest: PermissionRequest?,
                    permissionToken: PermissionToken?
                ) {
                }
            }).check()
    }

    private fun runFlashlight() {
        imageButton!!.setOnClickListener() {
                if (!state) {
                    val cameraManager =
                        getSystemService(Context.CAMERA_SERVICE) as CameraManager
                    try {
                        val cameraId = cameraManager.cameraIdList[0]
                        cameraManager.setTorchMode(cameraId, true)
                        state = true
                        imageButton!!.setImageResource(R.drawable.torch_on)
                    } catch (e: CameraAccessException) {
                    }
                } else {
                    val cameraManager =
                        getSystemService(Context.CAMERA_SERVICE) as CameraManager
                    try {
                        val cameraId = cameraManager.cameraIdList[0]
                        cameraManager.setTorchMode(cameraId, false)
                        state = false
                        imageButton!!.setImageResource(R.drawable.torch_off)
                    } catch (e: CameraAccessException) {
                    }
                }
            }
        }
    }
