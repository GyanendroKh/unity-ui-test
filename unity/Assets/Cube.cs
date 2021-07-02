using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cube : MonoBehaviour
{
	void Update()
	{
		transform.Rotate(0, Time.deltaTime*15, 0);
	}

	void OnGUI() {
		GUIStyle style = new GUIStyle("button");
		style.fontSize = 30;        
		if (GUI.Button(new Rect(10, 10, 200, 100), "Quit", style)) {
			Debug.Log("Quit");
		}
	}
}

