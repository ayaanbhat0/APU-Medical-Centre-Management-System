<?xml version="1.0" encoding="UTF-8" ?>

<Form version="1.3" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.JFrameFormInfo">
  <Properties>
    <Property name="defaultCloseOperation" type="int" value="3"/>
  </Properties>
  <SyntheticProperties>
    <SyntheticProperty name="formSizePolicy" type="int" value="1"/>
    <SyntheticProperty name="generateCenter" type="boolean" value="false"/>
  </SyntheticProperties>
  <AuxValues>
    <AuxValue name="FormSettings_autoResourcing" type="java.lang.Integer" value="0"/>
    <AuxValue name="FormSettings_autoSetComponentName" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_generateFQN" type="java.lang.Boolean" value="true"/>
    <AuxValue name="FormSettings_generateMnemonicsCode" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_i18nAutoMode" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_layoutCodeTarget" type="java.lang.Integer" value="1"/>
    <AuxValue name="FormSettings_listenerGenerationStyle" type="java.lang.Integer" value="0"/>
    <AuxValue name="FormSettings_variablesLocal" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_variablesModifier" type="java.lang.Integer" value="2"/>
  </AuxValues>

  <Layout>
    <DimensionLayout dim="0">
      <Group type="103" groupAlignment="0" attributes="0">
          <Group type="102" attributes="0">
              <EmptySpace min="-2" pref="43" max="-2" attributes="0"/>
              <Group type="103" groupAlignment="0" attributes="0">
                  <Component id="jLabel1" alignment="0" min="-2" max="-2" attributes="0"/>
                  <Component id="cmbPatient" alignment="0" min="-2" pref="575" max="-2" attributes="0"/>
                  <Group type="103" alignment="0" groupAlignment="1" max="-2" attributes="0">
                      <Group type="102" attributes="0">
                          <Component id="jButton1" min="-2" pref="75" max="-2" attributes="0"/>
                          <EmptySpace max="32767" attributes="0"/>
                          <Component id="btnSave" min="-2" pref="75" max="-2" attributes="0"/>
                      </Group>
                      <Group type="102" attributes="0">
                          <Group type="103" groupAlignment="0" attributes="0">
                              <Component id="jLabel2" alignment="0" min="-2" max="-2" attributes="0"/>
                              <Component id="jLabel3" alignment="0" min="-2" max="-2" attributes="0"/>
                          </Group>
                          <EmptySpace min="-2" pref="124" max="-2" attributes="0"/>
                          <Group type="103" groupAlignment="0" max="-2" attributes="0">
                              <Component id="jScrollPane1" pref="369" max="32767" attributes="0"/>
                              <Component id="txtCharges" max="32767" attributes="0"/>
                          </Group>
                      </Group>
                  </Group>
              </Group>
              <EmptySpace pref="55" max="32767" attributes="0"/>
          </Group>
      </Group>
    </DimensionLayout>
    <DimensionLayout dim="1">
      <Group type="103" groupAlignment="0" attributes="0">
          <Group type="102" alignment="0" attributes="0">
              <EmptySpace min="-2" pref="23" max="-2" attributes="0"/>
              <Component id="jLabel1" min="-2" max="-2" attributes="0"/>
              <EmptySpace type="separate" max="-2" attributes="0"/>
              <Component id="cmbPatient" min="-2" pref="77" max="-2" attributes="0"/>
              <EmptySpace min="-2" pref="24" max="-2" attributes="0"/>
              <Group type="103" groupAlignment="3" attributes="0">
                  <Component id="jLabel2" alignment="3" min="-2" max="-2" attributes="0"/>
                  <Component id="txtCharges" alignment="3" min="-2" pref="33" max="-2" attributes="0"/>
              </Group>
              <Group type="103" groupAlignment="0" attributes="0">
                  <Group type="102" attributes="0">
                      <EmptySpace min="22" pref="22" max="-2" attributes="0"/>
                      <Component id="jLabel3" min="-2" max="-2" attributes="0"/>
                  </Group>
                  <Group type="102" alignment="0" attributes="0">
                      <EmptySpace type="separate" max="-2" attributes="0"/>
                      <Component id="jScrollPane1" min="-2" pref="58" max="-2" attributes="0"/>
                  </Group>
              </Group>
              <EmptySpace pref="35" max="32767" attributes="0"/>
              <Group type="103" groupAlignment="3" attributes="0">
                  <Component id="btnSave" alignment="3" min="-2" max="-2" attributes="0"/>
                  <Component id="jButton1" alignment="3" min="-2" max="-2" attributes="0"/>
              </Group>
              <EmptySpace min="-2" pref="29" max="-2" attributes="0"/>
          </Group>
      </Group>
    </DimensionLayout>
  </Layout>
  <SubComponents>
    <Component class="javax.swing.JLabel" name="jLabel1">
      <Properties>
        <Property name="font" type="java.awt.Font" editor="org.netbeans.beaninfo.editors.FontEditor">
          <Font name="Segoe UI" size="24" style="0"/>
        </Property>
        <Property name="text" type="java.lang.String" value="Charges And Feedback"/>
        <Property name="name" type="java.lang.String" value="lblChargesAndFeedback" noResource="true"/>
      </Properties>
    </Component>
    <Component class="javax.swing.JButton" name="jButton1">
      <Properties>
        <Property name="text" type="java.lang.String" value="Back"/>
        <Property name="name" type="java.lang.String" value="btnBack" noResource="true"/>
      </Properties>
      <Events>
        <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="jButton1ActionPerformed"/>
      </Events>
    </Component>
    <Component class="javax.swing.JButton" name="btnSave">
      <Properties>
        <Property name="text" type="java.lang.String" value="Save"/>
        <Property name="name" type="java.lang.String" value="btnSave" noResource="true"/>
      </Properties>
      <Events>
        <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="btnSaveActionPerformed"/>
      </Events>
    </Component>
    <Component class="javax.swing.JLabel" name="jLabel2">
      <Properties>
        <Property name="text" type="java.lang.String" value="Enter Charges"/>
        <Property name="name" type="java.lang.String" value="lblCharges" noResource="true"/>
      </Properties>
    </Component>
    <Component class="javax.swing.JTextField" name="txtCharges">
      <Properties>
        <Property name="name" type="java.lang.String" value="txtCharges" noResource="true"/>
      </Properties>
    </Component>
    <Component class="javax.swing.JLabel" name="jLabel3">
      <Properties>
        <Property name="text" type="java.lang.String" value="Enter Feedback"/>
        <Property name="name" type="java.lang.String" value="lblFeedback" noResource="true"/>
      </Properties>
    </Component>
    <Container class="javax.swing.JScrollPane" name="jScrollPane1">
      <AuxValues>
        <AuxValue name="autoScrollPane" type="java.lang.Boolean" value="true"/>
      </AuxValues>

      <Layout class="org.netbeans.modules.form.compat2.layouts.support.JScrollPaneSupportLayout"/>
      <SubComponents>
        <Component class="javax.swing.JTextArea" name="txtFeedback">
          <Properties>
            <Property name="columns" type="int" value="20"/>
            <Property name="rows" type="int" value="5"/>
            <Property name="name" type="java.lang.String" value="txtFeedback" noResource="true"/>
          </Properties>
        </Component>
      </SubComponents>
    </Container>
    <Component class="javax.swing.JComboBox" name="cmbPatient">
      <Properties>
        <Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor">
          <StringArray count="0"/>
        </Property>
        <Property name="name" type="java.lang.String" value="cmbPatient" noResource="true"/>
      </Properties>
      <AuxValues>
        <AuxValue name="JavaCodeGenerator_TypeParameters" type="java.lang.String" value="&lt;String&gt;"/>
      </AuxValues>
    </Component>
  </SubComponents>
</Form>
