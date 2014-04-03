class Match < ActiveRecord::Base
  belongs_to :equipo_local, :class_name => Team
  belongs_to :equipo_visitante, :class_name => Team
  belongs_to :ganador, :class_name => Team
  belongs_to :perdedor, :class_name => Team
  belongs_to :grupo, :class_name => Group
  belongs_to :estadio, :class_name => Stadium
end
