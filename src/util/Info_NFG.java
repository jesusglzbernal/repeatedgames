/*******************************************************************************
 * Copyright (c) 2011 Enrique Munoz de Cote.
 * repeatedgames is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * repeatedgames is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with repeatedgames.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Please send an email to: jemc@inaoep.mx for comments or to become part of this project.
 * Contributors:
 *     Enrique Munoz de Cote - initial API and implementation
 ******************************************************************************/
package util;

import java.util.Vector;

/**
 * @author Enrique Munoz de Cote
 *
 */
public class Info_NFG implements ObservableEnvInfo {
	protected Object[] jointO;
	private Vector<Action> jointAction = new Vector();
	
	public Info_NFG(){
	}
	
	public Info_NFG(Vector<Action> j){
		Init(j);
	}
	
	public Vector<Action> currentJointAction(){
		
		for (int i = 0; i < jointO.length; i++) {
			jointAction.get(i).changeToState(jointO[i]);
		}

		return jointAction;
	}

	public Vector<Object> currentState(){
		Vector<Object> o = new Vector<Object>();
		for (Action c : jointAction) {
			o.add(c.getCurrentState());
		}
		return o;
	}
	
	public void updateJointAction(Vector<Action> j){
		for (int i = 0; i < j.size(); i++) {
			jointO[i] = j.get(i).getCurrentState();
		}
	}
	
	public void Init(Vector<Action> j){
		jointO = new Object[j.size()];
		
		for (int i = 0; i < j.size(); i++) {
			jointO[i] = j.get(i).getCurrentState();
			jointAction.add(j.get(i).newInstance());
		}
	}
}
