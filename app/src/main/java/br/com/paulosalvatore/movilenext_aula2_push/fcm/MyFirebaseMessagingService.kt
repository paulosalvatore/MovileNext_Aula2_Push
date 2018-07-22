package br.com.paulosalvatore.movilenext_aula2_push.fcm

import android.util.Log
import br.com.paulosalvatore.movilenext_aula2_push.notification.NotificationCreation
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

	private val tag: String = "FMService"

	override fun onNewToken(token: String?) {
		Log.i("NEW_TOKEN", token)

		FirebaseMessaging.getInstance().subscribeToTopic("MAIN")
	}

	override fun onMessageReceived(remoteMessage: RemoteMessage) {
		val notification = remoteMessage.notification

		Log.d(tag, "FCM Message ID: ${remoteMessage.messageId}")
		Log.d(tag, "FCM Data Message: ${remoteMessage.data}")
		Log.d(tag, "FCM Notification Message: $notification")

		notification?.let {
			val title = it.title ?: "Default Title"
			val body = it.body ?: "Default Body"
			val data = remoteMessage.data

			Log.d(tag, "FCM Notification Title: $title")
			Log.d(tag, "FCM Notification Body: $body")
			Log.d(tag, "FCM Notification Data: $data")

			// Criar a notificação
			NotificationCreation.create(this, title, body)
		}
	}
}
