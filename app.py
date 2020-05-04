from flask import Flask, request, redirect, url_for, flash, jsonify
import numpy as np
import pickle as p
import json

app = Flask(__name__)

@app.route('/api/', methods=['GET', 'POST'])
def api_echo():
    if request.method == 'GET':
        return("ECHO: GET\n")
    elif request.method == 'POST':
        data = request.get_json()
        print("requestjason", request.get_json())
        return jsonify(response="gottacha!!!")
    else:
        return("ECHO: Error\n")
    
if __name__ == '__main__':
    app.run(debug = True, host='0.0.0.0')
